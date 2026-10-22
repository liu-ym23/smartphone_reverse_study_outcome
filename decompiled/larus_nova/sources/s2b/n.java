package s2b;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes35.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f540376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f540377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f540378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f540379d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g2b.c f540380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f540381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f540382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f540383d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f540384e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public b f540385f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f540386g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f540387h;

        public a() {
            this.f540380a = null;
            this.f540381b = 48;
            this.f540382c = 0;
            this.f540383d = false;
            this.f540384e = 2.1474836E9f;
            this.f540386g = false;
            this.f540387h = -1;
        }
    }

    public interface b {
        void a();
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g2b.c f540388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f540389b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f540390c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f540391d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f540392e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b f540393f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f540394g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f540395h;

        public c(a r100) {
            this.f540388a = r100.f540380a;
            this.f540389b = r100.f540381b;
            this.f540390c = r100.f540382c;
            this.f540391d = r100.f540383d;
            this.f540392e = r100.f540384e;
            this.f540393f = r100.f540385f;
            this.f540394g = r100.f540386g;
            this.f540395h = r100.f540387h;
        }
    }

    public interface d {
        int a();
    }

    public n() {
        this.f540377b = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Runnable, s2b.h] */
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
    public final void a(final c r110) {
        Log.d("MessageListScroller", "scroll called");
        final RecyclerView r100 = this.f540376a;
        final b r101 = r110.f540393f;
        if (r100 != 0) goto L8;
        Log.i("MessageListScroller", "scroll before attachToRecycleView");
        this.f540379d = r110;
        if (r101 == null) goto L27;
        r101.a();
        return;
    L27:
        return;
    L8:
        h r102 = this.f540378c;
        if (r102 == null) goto L11;
        r100.removeCallbacks(r102);
    L11:
        final g2b.c r103 = r110.f540388a;
        final int r104 = r110.f540389b;
        int r105 = r110.f540390c;
        if (r104 == 80) goto L20;
        float r106 = r110.f540392e;
        if (r106 != 2.1474836E9f) goto L21;
        d r107 = this.f540377b;
        if (r107 == null) goto L19;
        r106 = r107.a();
        goto L21
    L19:
        final float r108 = 0.0f;
    L22:
        final boolean r109 = r110.f540391d;
        ?? r111 = new h(r100, r101, r103, r110, r109, r108, r104);
        this.f540378c = r111;
        if (r105 <= 0) goto L25;
        r100.postDelayed(r111, r105);
        return;
    L25:
        r111.run();
        return;
    L21:
        r108 = r106;
        goto L22
    L20:
        r106 = Math.min(r110.f540392e, 0.0f);
        goto L21
    }

    public final void b(int r100, boolean r101) {
        a r102 = new a();
        r102.f540381b = 80;
        r102.f540382c = r100;
        r102.f540383d = r101;
        r102.f540386g = true;
        r102.f540385f = null;
        a(new c(r102));
    }
}
