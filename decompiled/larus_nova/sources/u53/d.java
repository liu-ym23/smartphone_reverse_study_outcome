package u53;

/* JADX INFO: loaded from: classes12.dex */
public final class d extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f548815a;

    public static final class a {
    }

    static {
    }

    public d() {
        super("comment_card_pic_switch_click");
        this.f548815a = "";
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f548815a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_SWITCH_TYPE, r100, com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
    }
}
