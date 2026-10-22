package ulc;

import com.ss.ugc.live.sdk.message.data.LimitedSizeHashMap;
import tlc.d;
import vlc.k;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LimitedSizeHashMap f550645d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f550646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LimitedSizeHashMap f550647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LimitedSizeHashMap f550648c;

    /* JADX INFO: renamed from: ulc.a$a, reason: collision with other inner class name */
    public static class C7896a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f550649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f550650b;

        public C7896a(int r100, long r101) {
            this.f550649a = r100;
            this.f550650b = r101;
        }
    }

    @Override // ulc.b
    public final String getName() {
        return "MsgIdDuplicateWithType";
    }

    static {
        f550645d = new LimitedSizeHashMap(512);
    }

    public static String a(d r100) {
        return r100.getMessageMethod() + "_" + r100.getMessageId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vlc.b
    public final boolean onMessage(d r110) {
        int r100 = r110.getGeneralMessageType();
        String r101 = a(r110);
        if (r110.isGlobalMessage() == false) goto L9;
        LimitedSizeHashMap r111 = f550645d;
        if (r111.containsKey(r101) == false) goto L7;
        return true;
    L7:
        r111.put(r101, null);
        return false;
    L9:
        if (r100 == 0) goto L11;
        if (r100 == 1) goto L16;
    L23:
        return false;
    L16:
        if (this.f550648c.containsKey(r101) == false) goto L22;
        C7896a r102 = (C7896a) this.f550648c.get(r101);
        if (this.f550646a == null) goto L21;
        if (r102 == null) goto L21;
        long r112 = System.currentTimeMillis() - r102.f550650b;
        this.f550646a.b(r110.getMessageId(), r102.f550649a, r110.getMessageFrom(), r112);
    L21:
        return true;
    L22:
        long r103 = System.currentTimeMillis();
        C7896a r104 = new C7896a(r110.getMessageFrom(), r103);
        this.f550648c.put(a(r110), r104);
        goto L23
    L11:
        if (this.f550647b.containsKey(r101) == false) goto L13;
        return true;
    L13:
        this.f550647b.put(r101, null);
        goto L23
    }

    public a(k r100, int r101) {
        this.f550646a = r100;
        this.f550647b = new LimitedSizeHashMap(Math.max(r101, 512));
        this.f550648c = new LimitedSizeHashMap(Math.max(r101, 512));
    }
}
