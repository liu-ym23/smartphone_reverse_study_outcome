package fq9;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class q implements com.larus.business.markdown.api.depend.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f478443a;

    public static final class a implements tsc.n {
        public a() {
        }

        @Override // tsc.n
        public final void d(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final boolean t() {
        return false;
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final boolean v() {
        return false;
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final boolean x() {
        return false;
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final boolean y() {
        return false;
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final List<com.larus.business.markdown.api.depend.a> a() {
        return (List) this.f478443a.f478449f.getValue();
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final hw8.b b() {
        return (hw8.b) this.f478443a.f478452i.getValue();
    }

    public final lw8.n c() {
        return (lw8.n) this.f478443a.f478457n.getValue();
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final jw8.a e() {
        return (jw8.a) this.f478443a.f478451h.getValue();
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final com.larus.business.markdown.api.extplugin.image.a h() {
        return (com.larus.business.markdown.api.extplugin.image.a) this.f478443a.f478450g.getValue();
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final boolean i() {
        return ((Boolean) this.f478443a.f478453j.getValue()).booleanValue();
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final boolean isMarkdownStreamOptimized() {
        return ((Boolean) this.f478443a.f478445b.getValue()).booleanValue();
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final boolean j() {
        return ((Boolean) this.f478443a.f478460q.getValue()).booleanValue();
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final mw8.a k() {
        return (mw8.a) this.f478443a.f478444a.getValue();
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final int l() {
        return ((Number) this.f478443a.f478447d.getValue()).intValue();
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final Integer m() {
        if (((Number) this.f478443a.f478448e.getValue()).intValue() >= 0) goto L6;
        return null;
    L6:
        return Integer.valueOf(((Number) this.f478443a.f478448e.getValue()).intValue());
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final boolean n() {
        return ((Boolean) this.f478443a.f478458o.getValue()).booleanValue();
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final boolean o() {
        return ((Boolean) this.f478443a.f478454k.getValue()).booleanValue();
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final boolean p() {
        return ((Boolean) this.f478443a.f478455l.getValue()).booleanValue();
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final boolean q() {
        return ((Boolean) this.f478443a.f478456m.getValue()).booleanValue();
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final tsc.n r() {
        return new a();
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final boolean s() {
        return ((Boolean) this.f478443a.f478459p.getValue()).booleanValue();
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final Map<String, kw8.a> u() {
        return (Map) this.f478443a.f478462s.getValue();
    }

    @Override // com.larus.business.markdown.api.depend.e
    public final boolean w() {
        return ((Boolean) this.f478443a.f478446c.getValue()).booleanValue();
    }

    public q(r r100) {
        this.f478443a = r100;
    }
}
