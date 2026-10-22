package t91;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IRoom f545071a;

    /* JADX INFO: renamed from: t91.a$a, reason: collision with other inner class name */
    public static final class C7698a {
    }

    static {
    }

    public a(IRoom r100) {
        this.f545071a = r100;
    }

    @Override // s91.c
    public final u91.a a(Object r100) {
        ((Number) r100).intValue();
        IRoom r101 = this.f545071a;
        Integer r102 = null;
        if (r101 == null) goto L7;
        AnchorTabLabel r103 = r101.getAnchorTabLabel();
        if (r103 == null) goto L7;
        Integer r104 = Integer.valueOf(r103.getStyle());
    L8:
        AnchorTabLabel.Companion r105 = AnchorTabLabel.Companion;
        int r106 = r105.getIMAGE_STYLE();
        if (r104 != null) goto L12;
    L14:
        int r107 = r105.getIMAGE_AND_TEXT_STYLE();
        if (r104 != null) goto L18;
    L20:
        int r108 = r105.getTEXT_STYLE();
        if (r104 != null) goto L24;
    L26:
        StringBuilder r109 = new StringBuilder("illegal label style: ");
        IRoom r110 = this.f545071a;
        if (r110 == null) goto L31;
        AnchorTabLabel r111 = r110.getAnchorTabLabel();
        if (r111 == null) goto L31;
        r102 = Integer.valueOf(r111.getStyle());
    L31:
        r109.append(r102);
        ALogger.i("AudienceMultiFormatInitDataLoader", r109.toString());
        return new u91.a(new o91.b.C7023b());
    L24:
        if (r104.intValue() != r108) goto L26;
        return new u91.a(new o91.b.d());
    L18:
        if (r104.intValue() != r107) goto L20;
        return new u91.a(new o91.b.c());
    L12:
        if (r104.intValue() != r106) goto L14;
        return new u91.a(new o91.b.C7023b());
    L7:
        r104 = null;
        goto L8
    }

    @Override // s91.c
    public final boolean b(boolean r100, int r101, Integer r102) {
        int r103 = r102.intValue();
        if (r100 == false) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L25;
        IRoom r105 = this.f545071a;
        if (r105 != null) goto L12;
    L14:
        boolean r106 = false;
    L15:
        if (r106 == false) goto L25;
        if (r103 != 8) goto L19;
    L22:
        boolean r107 = true;
    L23:
        if (r107 == false) goto L25;
        return true;
    L19:
        if (r103 == 9) goto L22;
        r107 = false;
        goto L23
    L12:
        if (r105.getAnchorTabLabel() == null) goto L14;
        r106 = true;
    L25:
        return false;
    L5:
        if (r101 != 2) goto L7;
        r104 = true;
        goto L8
    }
}
