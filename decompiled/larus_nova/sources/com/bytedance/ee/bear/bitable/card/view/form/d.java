package com.bytedance.ee.bear.bitable.card.view.form;

import com.bytedance.ee.bear.bitable.card.viewmodel.share.ShareRecordInfo;
import com.bytedance.ee.bear.bitable.card.viewmodel.share.ShareRequestInfo;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.share.IShareMeta;
import io.reactivex.functions.BiFunction;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T1, T2, R> f208427a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f208428a = null;

        static {
            int[] r100 = new int[EFieldUIType.values().length];
            r100[EFieldUIType.USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[EFieldUIType.ATTACHMENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[EFieldUIType.FORMULA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[EFieldUIType.LOOKUP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[EFieldUIType.SINGLE_LINK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[EFieldUIType.DUPLEX_LINK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f208428a = r100;
        }
    }

    static {
        f208427a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r110, Object r111) {
        IShareMeta r112 = (IShareMeta) r110;
        cp4.b r113 = (cp4.b) r111;
        Intrinsics.checkNotNullParameter(r112, "shareMeta");
        tt5.a.b("CommonGenShareParamsPanel", "shareToken=" + r112.getShareToken() + " isOpen=" + r112.isOpen());
        ShareRecordInfo r100 = new ShareRecordInfo(false, false, false, false, false, 31, null);
        boolean r101 = false;
        if (r113 == null) goto L24;
        Map<String, fp4.g> r114 = r113.f464665i;
        if (r114 == null) goto L24;
        Iterator<fp4.g> r115 = r114.values().iterator();
        boolean r102 = false;
        boolean r103 = false;
        boolean r104 = false;
        boolean r105 = false;
    L8:
        if (r115.hasNext() == false) goto L25;
        fp4.g r106 = r115.next();
        if (r101 == false) goto L17;
        if (r102 == false) goto L17;
        if (r103 == false) goto L17;
        if (r104 == false) goto L17;
        if (r105 == true) goto L25;
    L17:
        switch(a.f208428a[r106.f478257d.getUiType().ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L19;
            default: goto L8;
        };
    L19:
        r105 = true;
        goto L8
    L20:
        r103 = true;
        goto L8
    L21:
        r104 = true;
        goto L8
    L22:
        r102 = true;
        goto L8
    L23:
        r101 = true;
    L25:
        r100.setHasUserField(r101);
        r100.setHasAttachmentField(r102);
        com.bytedance.ee.bear.appsetting.c r116 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        if (r116.g("ccm.bitable.form_support_formula") == false) goto L29;
        r100.setHasLookupField(r103);
        r100.setHasFormulaField(r104);
    L29:
        if (r116.g("ccm.bitable.mobile.support_remote_compute") == false) goto L32;
        r100.setHasLinkField(r105);
    L32:
        return new ShareRequestInfo(r112, r100);
    L24:
        r102 = false;
        r103 = false;
        r104 = false;
        r105 = false;
        goto L25
    }
}
