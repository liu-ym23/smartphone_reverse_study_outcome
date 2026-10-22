package com.bytedance.bmf;

import com.bytedance.hmp.Ptr;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes43.dex */
public class ModuleFunctor extends Ptr {
    boolean cleanup;
    Class[] inputTypes;
    Class[] outputTypes;

    public void free() {
        if (this.own == false) goto L6;
        API.bmf_module_functor_free(this.ptr);
        return;
    }

    public Packet[] _inputs(Object[] r110) throws Exception {
        if (r110 == null) goto L4;
        int r100 = r110.length;
        Class[] r101 = this.inputTypes;
        int r102 = 0;
        if (r100 != r101.length) goto L30;
        int r103 = r101.length;
        Packet[] r104 = new Packet[r103];
        int r105 = 0;
    L31:
    L22:
        e = move-exception;
    L23:
        if (r102 >= r103) goto L28;
        Packet r106 = r104[r102];
        if (r106 == null) goto L27;
        r106.free();
    L27:
        r102 = r102 + 1;
        goto L23
    L28:
        throw e;
    L9:
        if (r105 >= r110.length) goto L21;
        Object r107 = r110[r105];     // Catch: Exception -> L22
        if (r107 == null) goto L19;
        Class r108 = this.inputTypes[r105];     // Catch: Exception -> L22
        if (r108 == null) goto L19;
        if (r108.isInstance(r107) == true) goto L19;
        throw new IllegalArgumentException(String.format("Expect input type %s at %d, got %s", new Object[]{this.inputTypes[r105].getName(), Integer.valueOf(r105), r110[r105].getClass().getName()}));     // Catch: Exception -> L22
    L19:
        r104[r105] = new Packet(r110[r105]);     // Catch: Exception -> L22
        r105 = r105 + 1;
        goto L31
    L21:
        return r104;
    L30:
        throw new IllegalArgumentException(String.format("Expect %d inputs, got %d", new Object[]{Integer.valueOf(this.inputTypes.length), Integer.valueOf(r110.length)}));
    L4:
        return new Packet[this.inputTypes.length];
    }

    public Object[] call(Object... r110) throws Exception {
        Packet[] r111 = _inputs(r110);
        int r100 = this.outputTypes.length;
        Packet[] r101 = new Packet[r100];
        int r102 = 0;
        long[] r103 = new long[r111.length];     // Catch: Throwable -> L50
        int r104 = 0;
    L5:
        if (r104 >= r111.length) goto L7;
        r103[r104] = r111[r104].getPtr();     // Catch: Throwable -> L50
        r104 = r104 + 1;     // Catch: Throwable -> L50
        goto L5
    L7:
        long[] r105 = API.bmf_module_functor_call(this.ptr, r103);     // Catch: Throwable -> L50
        if (r105 == null) goto L49;
        if (r105.length == this.outputTypes.length) goto L17;
        int r106 = 0;
    L13:
        if (r106 >= r105.length) goto L16;
        API.bmf_packet_free(r105[r106]);     // Catch: Throwable -> L50
        r106 = r106 + 1;     // Catch: Throwable -> L50
        goto L13
    L16:
        throw new IllegalStateException(String.format("Expect %d outputs, got %d", new Object[]{Integer.valueOf(this.outputTypes.length), Integer.valueOf(r105.length)}));     // Catch: Throwable -> L50
    L17:
        int r107 = 0;
    L19:
        if (r107 >= r105.length) goto L21;
        r101[r107] = Packet.wrap(r105[r107], true);     // Catch: Throwable -> L50
        r107 = r107 + 1;     // Catch: Throwable -> L50
        goto L19
    L21:
        int r108 = 0;
    L22:
        if (r108 >= r100) goto L33;
        if (r101[r108].getPtr() == 0) goto L32;
        Class r109 = this.outputTypes[r108];     // Catch: Throwable -> L50
        if (r109 == null) goto L32;
        if (r101[r108].is(r109) == true) goto L32;
        throw new IllegalStateException(String.format("Invalid output packet type at port %d, expect %s", new Object[]{Integer.valueOf(r108), this.outputTypes[r108].getName()}));     // Catch: Throwable -> L50
    L32:
        r108 = r108 + 1;     // Catch: Throwable -> L50
        goto L22
    L33:
        Object[] r112 = new Object[r105.length];     // Catch: Throwable -> L50
        int r113 = 0;
    L35:
        if (r113 >= r105.length) goto L38;
        r112[r113] = _output(r101[r113], r113);     // Catch: Throwable -> L50
        r113 = r113 + 1;
        goto L35
    L38:
        int r114 = 0;
    L40:
        if (r114 >= r111.length) goto L42;
        r111[r114].free();
        r114 = r114 + 1;
    L42:
        if (r102 >= r100) goto L47;
        Packet r115 = r101[r102];
        if (r115 == null) goto L46;
        r115.free();
    L46:
        r102 = r102 + 1;
        goto L42
    L47:
        return r112;
    L49:
        throw new IllegalStateException("output pkt (opktPtrs) is null");     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L63
        int r116 = 0;
    L54:
        if (r116 >= r111.length) goto L56;
        r111[r116].free();
        r116 = r116 + 1;
    L56:
        if (r102 >= r100) goto L61;
        Packet r117 = r101[r102];
        if (r117 == null) goto L60;
        r117.free();
    L60:
        r102 = r102 + 1;
        goto L56
    L61:
        return null;
    L63:
        th = move-exception;
        int r118 = 0;
    L66:
        if (r118 >= r111.length) goto L68;
        r111[r118].free();
        r118 = r118 + 1;
    L68:
        if (r102 >= r100) goto L73;
        Packet r119 = r101[r102];
        if (r119 == null) goto L72;
        r119.free();
    L72:
        r102 = r102 + 1;
        goto L68
    L73:
        throw th;
    }

    public void execute(Object... r100) throws Exception {
        Packet[] r101 = _inputs(r100);
        int r102 = 0;
        long[] r103 = new long[r101.length];     // Catch: Throwable -> L12
        int r104 = 0;
    L5:
        if (r104 >= r101.length) goto L7;
        r103[r104] = r101[r104].getPtr();     // Catch: Throwable -> L12
        r104 = r104 + 1;     // Catch: Throwable -> L12
        goto L5
    L7:
        API.bmf_module_functor_execute(this.ptr, r103, this.cleanup);     // Catch: Throwable -> L12
    L9:
        if (r102 >= r101.length) goto L11;
        r101[r102].free();
        r102 = r102 + 1;
        goto L9
    L11:
        return;
    L12:
        th = move-exception;
    L14:
        if (r102 >= r101.length) goto L16;
        r101[r102].free();
        r102 = r102 + 1;
        goto L14
    L16:
        throw th;
    }

    public Object[] fetch(int r110) throws Exception {
        long[] r100 = API.bmf_module_functor_fetch(this.ptr, r110);
        int r101 = r100.length;
        Packet[] r102 = new Packet[r101];
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= r100.length) goto L6;
        r102[r104] = Packet.wrap(r100[r104], true);
        r104 = r104 + 1;
        goto L4
    L6:
        int r105 = 0;
    L7:
        if (r105 >= r101) goto L18;
    L26:
        th = move-exception;
    L27:
        if (r103 >= r101) goto L29;
        r102[r103].free();
        r103 = r103 + 1;
        goto L27
    L29:
        throw th;
    L9:
        if (r102[r105].getPtr() == 0) goto L17;
        Class r106 = this.outputTypes[r110];     // Catch: Throwable -> L26
        if (r106 == null) goto L17;
        if (r102[r105].is(r106) == true) goto L17;
        throw new IllegalStateException(String.format("Invalid output packet type at %d from port %d, expect %s", new Object[]{Integer.valueOf(r105), Integer.valueOf(r110), this.outputTypes[r110].getName()}));     // Catch: Throwable -> L26
    L17:
        r105 = r105 + 1;     // Catch: Throwable -> L26
        goto L7
    L18:
        Object[] r107 = new Object[r100.length];     // Catch: Throwable -> L26
        int r108 = 0;
    L20:
        if (r108 >= r100.length) goto L23;
        r107[r108] = _output(r102[r108], r110);     // Catch: Throwable -> L26
        r108 = r108 + 1;
    L23:
        if (r103 >= r101) goto L25;
        r102[r103].free();
        r103 = r103 + 1;
        goto L23
    L25:
        return r107;
    }

    public ModuleFunctor(long r100, boolean r101) {
        this.cleanup = true;
        this.ptr = r100;
        this.own = r101;
    }

    public static ModuleFunctor wrap(long r100, boolean r101) {
        return new ModuleFunctor(r100, r101);
    }

    public Object _output(Packet r100, int r101) throws Exception {
        if (r100.getPtr() != 0) goto L6;
        return null;
    L6:
        Class r102 = this.outputTypes[r101];
        if (r102 != null) goto L10;
        return r100;
    L10:
        return r100.get(r102);
    }

    public ModuleFunctor(ModuleInfo r110, Object r111, Class[] r112, Class[] r113) {
        this.cleanup = true;
        String r100 = GsonProtectorUtils.toJson(new Gson(), r111);
        this.ptr = API.bmf_module_functor_make(r110.name, r110.type, r110.path, r110.entry, r100, r112.length, r113.length, -1);
        this.own = true;
        this.inputTypes = r112;
        this.outputTypes = r113;
    }

    public ModuleFunctor(ModuleInfo r100, Object r101, Class[] r102, Class[] r103, boolean r104) {
        this(r100, r101, r102, r103);
        this.cleanup = r104;
    }
}
