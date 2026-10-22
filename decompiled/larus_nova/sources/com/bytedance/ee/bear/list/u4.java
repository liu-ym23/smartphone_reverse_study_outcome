package com.bytedance.ee.bear.list;

import android.content.Context;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class u4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u4 f229807a = null;

    static {
        f229807a = new u4();
    }

    public u4() {
    }

    public static String a(Context r100, int r101) {
        if (r100 != null) goto L6;
        tt5.a.h("SpaceCoreUtil", "context is null");
        return "";
    L6:
        if (sbb.g.b(r101) == false) goto L10;
        return r100.getString(R.string.LarkCCM_Common_app_Variable);
    L10:
        if (r101 != sbb.e.f541295f.f541317b) goto L13;
        String r102 = r100.getString(R.string.Doc_List_TypeSimpleNameFolder);
        Intrinsics.checkNotNull(r102);
        return r102;
    L13:
        if (r101 != sbb.e.f541306q.f541317b) goto L16;
        String r103 = r100.getString(R.string.CreationMobile_Minutes_name);
        Intrinsics.checkNotNull(r103);
        return r103;
    L16:
        if (r101 != sbb.e.f541301l.f541317b) goto L19;
        String r104 = r100.getString(R.string.Doc_Facade_MoreRenameTypeFile);
        Intrinsics.checkNotNull(r104);
        return r104;
    L19:
        if (r101 != sbb.e.f541311v.f541317b) goto L21;
        String r105 = r100.getString(R.string.LarkCCM_ChatShare_ChatSc_Text);
        Intrinsics.checkNotNull(r105);
        return r105;
    L21:
        String r106 = r100.getString(R.string.Doc_List_TypeSimpleNameDoc);
        Intrinsics.checkNotNull(r106);
        return r106;
    }
}
