package com.lynx.markdown;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f381434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f381435b;

    public g() {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        this.f381434a = r100;
        this.f381435b = new k(r100);
    }

    public final void a(ArrayList<Object> r100) throws IOException {
        this.f381435b.writeInt(2);
        if (r100 != null) goto L6;
        this.f381435b.writeInt(0);
        return;
    L6:
        this.f381435b.writeInt(r100.size());
        Iterator<Object> r101 = r100.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        c(r101.next());
        goto L8
    }

    public final void b(HashMap<String, Object> r100) throws IOException {
        this.f381435b.writeInt(1);
        if (r100 != null) goto L6;
        this.f381435b.writeInt(0);
        return;
    L6:
        this.f381435b.writeInt(r100.size());
        Iterator<String> r101 = r100.keySet().iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        String r102 = r101.next();
        k r103 = this.f381435b;
        r103.getClass();
        byte[] r104 = r102.getBytes(StandardCharsets.UTF_8);
        r103.writeInt(r104.length);
        r103.write(r104, 0, r104.length);
        c(r100.get(r102));
        goto L8
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void c(Object r100) throws IOException {
        if (r100 != null) goto L6;
        this.f381435b.writeInt(0);
        return;
    L6:
        if ((r100 instanceof Boolean) == false) goto L9;
        boolean r101 = ((Boolean) r100).booleanValue();
        this.f381435b.writeInt(3);
        this.f381435b.writeByte(r101 ? 1 : 0);
        return;
    L9:
        if ((r100 instanceof Integer) == false) goto L12;
        int r102 = ((Integer) r100).intValue();
        this.f381435b.writeInt(4);
        this.f381435b.writeInt(r102);
        return;
    L12:
        if ((r100 instanceof Long) == false) goto L15;
        long r103 = ((Long) r100).longValue();
        this.f381435b.writeInt(5);
        this.f381435b.writeLong(r103);
        return;
    L15:
        if ((r100 instanceof Number) == false) goto L18;
        double r104 = ((Number) r100).doubleValue();
        this.f381435b.writeInt(6);
        this.f381435b.writeDouble(r104);
        return;
    L18:
        if ((r100 instanceof String) == false) goto L21;
        this.f381435b.writeInt(7);
        k r105 = this.f381435b;
        r105.getClass();
        byte[] r106 = ((String) r100).getBytes(StandardCharsets.UTF_8);
        r105.writeInt(r106.length);
        r105.write(r106, 0, r106.length);
        return;
    L21:
        if ((r100 instanceof ArrayList) == false) goto L24;
        a((ArrayList) r100);
        return;
    L24:
        if ((r100 instanceof HashMap) == false) goto L26;
        b((HashMap) r100);
        return;
    L26:
        this.f381435b.writeInt(0);
    }
}
