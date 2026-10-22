package xq4;

import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.bean.EditorLocation;
import com.bytedance.ee.bear.bitable.celleditor.editor.chatter.ChatterEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.chatter.ChatterType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends com.bytedance.ee.bear.bitable.celleditor.editor.c<ChatterEditorModel> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final hr4.a f564802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f564803e;

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final Class<ChatterEditorModel> c() {
        return ChatterEditorModel.class;
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final com.bytedance.ee.bear.bitable.celleditor.editor.b e() {
        return this.f564803e;
    }

    public c(hr4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        super(r100);
        this.f564802d = r100;
        this.f564803e = new a();
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final com.bytedance.ee.bear.bitable.celleditor.editor.g d(CommonEditorModel r110) {
        ChatterEditorModel r111 = (ChatterEditorModel) r110;
        Intrinsics.checkNotNullParameter(r111, "data");
        a r100 = this.f564803e;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.celleditor.editor.chatter.ChatterEditorActionHandler");
        String r101 = "";
        if (r111.getChatterType() != ChatterType.USER) goto L20;
        hr4.a r102 = this.f564802d;
        EditorLocation r103 = r111.getLocation();
        if (r103 == null) goto L10;
        String r104 = r103.getBaseId();
        if (r104 == null) goto L10;
        r101 = r104;
    L10:
        boolean r105 = r111.canShowNotifyBar();
        boolean r106 = r111.canShowCheckBox();
        Boolean r107 = r111.getNotifiesEnable();
        if (r107 == null) goto L13;
        boolean r108 = r107.booleanValue();
    L14:
        Boolean r112 = r111.getCanShowChatterInfoIcon();
        if (r112 == null) goto L17;
        boolean r113 = r112.booleanValue();
    L38:
        return new h(r102, r100, r101, r105, r106, r108, r113);
    L17:
        r113 = false;
        goto L38
    L13:
        r108 = true;
        goto L14
    L20:
        if (r111.getChatterType() != ChatterType.GROUP) goto L37;
        hr4.a r109 = this.f564802d;
        EditorLocation r114 = r111.getLocation();
        if (r114 == null) goto L27;
        String r115 = r114.getBaseId();
        if (r115 == null) goto L27;
        r101 = r115;
    L27:
        Boolean r116 = r111.getCanShowChatterInfoIcon();
        if (r116 == null) goto L30;
        boolean r117 = r116.booleanValue();
    L32:
        if (Intrinsics.areEqual(r111.getCanShowCreateGroup(), Boolean.TRUE) == false) goto L34;
        b r118 = new b(r100, this);
    L39:
        return new g(r109, r100, r101, r117, r118);
    L34:
        r118 = null;
        goto L39
    L30:
        r117 = false;
        goto L32
    L37:
        return null;
    }
}
