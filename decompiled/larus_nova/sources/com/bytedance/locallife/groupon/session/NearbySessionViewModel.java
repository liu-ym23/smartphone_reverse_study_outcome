package com.bytedance.locallife.groupon.session;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.feed.model.nearby.NearbyPageType;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ(\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010J<\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\u0013j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e`\u00142\b\b\u0002\u0010\u0011\u001a\u00020\u0010J2\u0010\u0016\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0013j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u0001`\u00142\u0006\u0010\f\u001a\u00020\bJ2\u0010\u0017\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0013j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u0001`\u00142\u0006\u0010\f\u001a\u00020\bJ2\u0010\u0018\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0013j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u0001`\u00142\u0006\u0010\f\u001a\u00020\bJ2\u0010\u0019\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0013j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u0001`\u00142\u0006\u0010\f\u001a\u00020\bJ2\u0010\u001a\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0013j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u0001`\u00142\u0006\u0010\f\u001a\u00020\bJ\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bJ\b\u0010\u001c\u001a\u00020\u0004H\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/bytedance/locallife/groupon/session/NearbySessionViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/ss/android/ugc/aweme/feed/model/nearby/NearbyPageType;", "pageType", "", "init", "Lcom/bytedance/locallife/groupon/session/d;", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "", "parentSessionId", "", "addSession", "sessionId", "key", "", "value", "Lcom/bytedance/locallife/groupon/session/SessionParamsType;", "type", "setSession", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "getSessionParams", "getCommomParams", "getSchemaParams", "getTrackParams", "getExtraParams", MonitorConstants.CONNECT_TYPE_GET, "onCleared", "Lcom/ss/android/ugc/aweme/feed/model/nearby/NearbyPageType;", "Lcom/bytedance/locallife/groupon/session/a;", "rootSession", "Lcom/bytedance/locallife/groupon/session/a;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-common_release"}, k = 1, mv = {1, 4, 3})
public final class NearbySessionViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String KEY = "nearby_session_vm";
    public static final String TAG = "NearbySessionVM";
    private NearbyPageType pageType;
    private com.bytedance.locallife.groupon.session.a rootSession;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        HashMap<String, NearbySessionViewModel> r100 = c.f258809a;
        String r101 = com.bytedance.locallife.groupon.basic.utils.d.b(this.pageType);
        Intrinsics.checkNotNullParameter(r101, "key");
        c.f258809a.remove(r101);
    }

    public NearbySessionViewModel() {
    }

    @JvmStatic
    public static final NearbySessionViewModel get(Fragment r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        if (r100.getActivity() != null) goto L7;
        return null;
    L7:
        return (NearbySessionViewModel) ViewModelProviders.of(r100).get(KEY, NearbySessionViewModel.class);
    }

    public final HashMap<String, Object> getCommomParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        com.bytedance.locallife.groupon.session.a r101 = this.rootSession;
        if (r101 == null) goto L5;
        HashMap<String, Object> r102 = r101.h(r100);
    L6:
        Objects.toString(r102);
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public final HashMap<String, Object> getExtraParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        com.bytedance.locallife.groupon.session.a r101 = this.rootSession;
        if (r101 == null) goto L5;
        HashMap<String, Object> r102 = r101.a(r100);
    L6:
        Objects.toString(r102);
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public final HashMap<String, Object> getSchemaParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        com.bytedance.locallife.groupon.session.a r101 = this.rootSession;
        if (r101 == null) goto L5;
        HashMap<String, Object> r102 = r101.g(r100);
    L6:
        Objects.toString(r102);
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public final HashMap<String, Object> getSessionParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        com.bytedance.locallife.groupon.session.a r101 = this.rootSession;
        if (r101 == null) goto L5;
        HashMap<String, Object> r102 = r101.f(r100);
    L6:
        Objects.toString(r102);
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public final HashMap<String, Object> getTrackParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        com.bytedance.locallife.groupon.session.a r101 = this.rootSession;
        if (r101 == null) goto L5;
        HashMap<String, Object> r102 = r101.k(r100);
    L6:
        Objects.toString(r102);
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public final void init(NearbyPageType r100) {
        Intrinsics.checkNotNullParameter(r100, "pageType");
        this.pageType = r100;
        this.rootSession = new b(com.bytedance.locallife.groupon.basic.utils.d.b(r100));
        HashMap<String, NearbySessionViewModel> r101 = c.f258809a;
        String r102 = com.bytedance.locallife.groupon.basic.utils.d.b(r100);
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(this, "viewModel");
        c.f258809a.put(r102, this);
    }

    public final boolean addSession(d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        com.bytedance.locallife.groupon.session.a r102 = this.rootSession;
        if (r102 == null) goto L5;
        com.bytedance.locallife.groupon.session.a r103 = r102.b(r100.f258810a);
    L7:
        if (r103 != null) goto L9;
    L18:
        com.bytedance.locallife.groupon.session.a r104 = this.rootSession;
        if (r104 == null) goto L24;
        r100.f258811b = r101;
        return r104.e(r100);
    L24:
        return false;
    L9:
        if (TextUtils.isEmpty(r101) == true) goto L18;
        if (TextUtils.equals(r101, r103.getParentSessionId()) == true) goto L18;
        com.bytedance.locallife.groupon.session.a r105 = this.rootSession;
        if (r105 == null) goto L15;
        r105.j(r100.f258810a);
    L15:
        com.bytedance.locallife.groupon.session.a r106 = this.rootSession;
        if (r106 == null) goto L22;
        r103.c(r101);
        return r106.e(r103);
    L22:
        return false;
    L5:
        r103 = null;
        goto L7
    }

    public final Object get(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "key");
        com.bytedance.locallife.groupon.session.a r102 = this.rootSession;
        if (r102 == null) goto L7;
        com.bytedance.locallife.groupon.session.a r103 = r102.b(r100);
        if (r103 == null) goto L7;
        return r103.get(r101);
    L7:
        return null;
    }

    public final void setSession(String r100, HashMap<String, Object> r101, SessionParamsType r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "type");
        com.bytedance.locallife.groupon.session.a r103 = this.rootSession;
        if (r103 == null) goto L6;
        r103.i(r100, r101, r102);
        return;
    }

    public final void setSession(String r100, String r101, Object r102, SessionParamsType r103) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        Intrinsics.checkNotNullParameter(r103, "type");
        com.bytedance.locallife.groupon.session.a r104 = this.rootSession;
        if (r104 == null) goto L6;
        r104.d(r100, r101, r102, r103);
        return;
    }

    public static /* synthetic */ boolean addSession$default(NearbySessionViewModel r100, d r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.addSession(r101, r102);
    }

    public static /* synthetic */ void setSession$default(NearbySessionViewModel r100, String r101, HashMap r102, SessionParamsType r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = SessionParamsType.COMMON_PARAMS;
    L5:
        r100.setSession(r101, r102, r103);
    }

    public static /* synthetic */ void setSession$default(NearbySessionViewModel r100, String r101, String r102, Object r103, SessionParamsType r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = SessionParamsType.COMMON_PARAMS;
    L5:
        r100.setSession(r101, r102, r103, r104);
    }
}
