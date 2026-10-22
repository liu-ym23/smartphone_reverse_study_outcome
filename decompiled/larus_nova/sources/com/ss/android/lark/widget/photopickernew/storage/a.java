package com.ss.android.lark.widget.photopickernew.storage;

import android.app.Activity;
import android.content.Context;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.utils.u;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Token f447954g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C5426a f447955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f447956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f447957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, c> f447958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f447959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, c> f447960f;

    /* JADX INFO: renamed from: com.ss.android.lark.widget.photopickernew.storage.a$a, reason: collision with other inner class name */
    public static final class C5426a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f447961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public StoragePermissionUtils.a f447962b;

        public C5426a() {
            this.f447961a = 6;
        }
    }

    public static final class b {
    }

    public interface c {
        void onClick();
    }

    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f447963a;

        @Override // com.ss.android.lark.widget.photopickernew.storage.a.c
        public final void onClick() {
            Token r100 = a.f447954g;
            a r101 = this.f447963a;
            Activity r102 = r101.f447956b;
            C5426a r103 = r101.f447955a;
            StoragePermissionUtils.a r104 = r103.f447962b;
            int r105 = r103.f447961a;
            r103.getClass();
            if (r102 == null) goto L7;
            if (r104 != null) goto L6;
            Log.w("StoragePermissionManager", "requestPermissionForAlbum / Given callback is null");
            r104 = com.ss.android.lark.widget.photopickernew.storage.b.f447965a;
        L6:
            Token r106 = a.f447954g;
            Log.i("StoragePermissionManager", "requestPermissionForAlbum / Use token = " + r106.getIdentifier());
            StoragePermissionUtils.f(r102, r104, r105, r106, new String[0]);
            return;
        L7:
            Log.e("StoragePermissionManager", "requestPermissionForAlbum / Given activity is null, failed to request permission");
        }

        public d(a r100) {
            this.f447963a = r100;
        }
    }

    public static final class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f447964a;

        @Override // com.ss.android.lark.widget.photopickernew.storage.a.c
        public final void onClick() {
            Token r100 = a.f447954g;
            Context r101 = this.f447964a.f447956b;
            if (r101 != null) goto L5;
            r101 = LarkContext.getApplication();
        L5:
            u.a(r101);
        }

        public e(a r100) {
            this.f447964a = r100;
        }
    }

    static {
        f447954g = new Token("LARK-PSDA-android_photo_picker_request_permission");
    }

    public a(C5426a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f447955a = r100;
        this.f447957c = new ArrayList();
        this.f447958d = new HashMap();
        this.f447959e = CollectionsKt.listOf(new String[]{UIHelper.getString(R.string.Lark_IM_AppCanOnlyAccessPhotosYouSelect_SelectMore_Button), UIHelper.getString(R.string.Lark_IM_AppCanOnlyAccessPhotosYouSelect_ChangeSettings_Button)});
        this.f447960f = MapsKt.mapOf(new Pair[]{TuplesKt.to(UIHelper.getString(R.string.Lark_IM_AppCanOnlyAccessPhotosYouSelect_SelectMore_Button), new d(this)), TuplesKt.to(UIHelper.getString(R.string.Lark_IM_AppCanOnlyAccessPhotosYouSelect_ChangeSettings_Button), new e(this))});
    }
}
