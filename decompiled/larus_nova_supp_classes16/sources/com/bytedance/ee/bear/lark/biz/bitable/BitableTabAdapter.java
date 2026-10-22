package com.bytedance.ee.bear.lark.biz.bitable;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.ee.bear.bitable.homepage.BitableTabType;
import com.bytedance.ee.bear.bitable.homepage.i0;
import com.bytedance.ee.bear.bitable.homepage.m0;
import com.bytedance.ee.bear.bitable.homepage.recommend.BitableRecommendFragment;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.lark.dependency.y;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.utils.LarkContext;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import vs4.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0002+,B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u000fH\u0002J\b\u0010#\u001a\u00020\u000fH\u0002J\b\u0010$\u001a\u00020\u000fH\u0002J\b\u0010%\u001a\u0004\u0018\u00010\u000fJ\b\u0010&\u001a\u00020'H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020'0)X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/lark/biz/bitable/BitableTabAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "Lcom/bytedance/ee/bear/bitable/homepage/IMenuScrollChangeNotifier;", "fm", "Landroidx/fragment/app/FragmentManager;", "mContext", "Landroid/content/Context;", "mTabInfoList", "", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeTabInfo;", "mHomePageCreateTime", "Lcom/bytedance/ee/bear/bitable/homepage/recommend/report/HomePageCreateTimeData;", "<init>", "(Landroidx/fragment/app/FragmentManager;Landroid/content/Context;Ljava/util/List;Lcom/bytedance/ee/bear/bitable/homepage/recommend/report/HomePageCreateTimeData;)V", "mCurrentFragment", "Landroidx/fragment/app/Fragment;", "onMenuScrollChangeListener", "Lcom/bytedance/ee/bear/list/list/IListAdapter$OnMenuScrollChangeListener;", "getOnMenuScrollChangeListener", "()Lcom/bytedance/ee/bear/list/list/IListAdapter$OnMenuScrollChangeListener;", "setOnMenuScrollChangeListener", "(Lcom/bytedance/ee/bear/list/list/IListAdapter$OnMenuScrollChangeListener;)V", "getItem", "position", "", "getCount", "getPageTitle", "", "setPrimaryItem", "", "container", "Landroid/view/ViewGroup;", "fragment", "", "getBitableFragment", "getWebFragment", "getRecommendFragment", "getCurrentFragment", "genTraceID", "", "chars", "", "[Ljava/lang/String;", "Companion", "BitableRecommendUrlConfig", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableTabAdapter extends FragmentPagerAdapter implements m0 {
    public final Context a;
    public final List<ad5.e> b;
    public final z c;
    public Fragment d;
    public com.bytedance.ee.bear.list.list.d.c e;
    public final String[] f;

    @AppConfig(key = "ccm_base_homepage_recommend_url")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/lark/biz/bitable/BitableTabAdapter$BitableRecommendUrlConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "homePageUrl", "", "getHomePageUrl", "()Ljava/lang/String;", "setHomePageUrl", "(Ljava/lang/String;)V", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BitableRecommendUrlConfig implements NonProguard {
        private String homePageUrl;

        public BitableRecommendUrlConfig() {
        }

        public final String getHomePageUrl() {
            return this.homePageUrl;
        }

        public final void setHomePageUrl(String r1) {
            this.homePageUrl = r1;
        }
    }

    public static final class a {
    }

    static {
    }

    public final Fragment f() {
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("bitable.homepage.new.native.enable") == false) goto L6;
        tt5.a.h("BitableTabAdapter", "[HomePage]Fg is enable, return BitableRecommendFragment");
        BitableRecommendFragment r0 = new BitableRecommendFragment();
        z r1 = this.c;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.e = r1;
        return r0;
    L6:
        tt5.a.h("BitableTabAdapter", "[HomePage]Fg is disable, return webFragment");
        BitableRecommendUrlConfig r2 = (BitableRecommendUrlConfig) SettingManager.getInstance().get(BitableRecommendUrlConfig.class);
        if (r2 == null) goto L9;
        r2.getHomePageUrl();
    L9:
        y r3 = (y) LarkContext.spiByDwarf(y.class);
        String r4 = StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, null);
        StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L15
        int r6 = 0;
    L11:
        if (r6 >= 8) goto L13;
        int r7 = r6 * 4;     // Catch: Exception -> L15
        int r8 = CastIntegerProtector.parseInt(r4.substring(r7, r7 + 4), CharsKt.checkRadix(16));     // Catch: Exception -> L15
        String[] r9 = this.f;     // Catch: Exception -> L15
        r5.append(r9[r8 % r9.length]);     // Catch: Exception -> L15
        r6 = r6 + 1;     // Catch: Exception -> L15
        goto L11
    L13:
        Intrinsics.checkNotNull(r5.toString());     // Catch: Exception -> L15
    L17:
        return r3.e();
    L15:
        r4.substring(0, 8);
        goto L17
    }

    public final int getCount() {
        return this.b.size();
    }

    public final void gL(com.bytedance.ee.bear.list.list.d.c r1) {
        this.e = r1;
    }

    public final Fragment getItem(int r4) {
        tt5.a.h("BitableTabAdapter", "getItem()...position = " + r4);
        if (hu5.a.a(r4, this.b) == false) goto L14;
        if (r4 == BitableTabType.RECOMMEND.getValue()) goto L7;
        BitableTabFragment r5 = new BitableTabFragment();
        r5.h = new i0(this.a);
        r5.k = new com.bytedance.ee.bear.lark.i(r5, null);
        r5.e = true;
        if (((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1().hasBenefit("base_create_base") == false) goto L11;
        r5.H = false;
    L11:
        z r0 = this.c;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r5.I = r0;
        r5.O = this.e;
        return r5;
    L7:
        return f();
    L14:
        return f();
    }

    public final CharSequence getPageTitle(int r3) {
        String r0 = ((ad5.e) ListProtector.get(this.b, r3)).d;
        if (r0 == null) goto L11;
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L11;
        return r0;
    L11:
        return this.a.getString(((ad5.e) ListProtector.get(this.b, r3)).b);
    }

    public final void setPrimaryItem(ViewGroup r2, int r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        this.d = (Fragment) r4;
        super.setPrimaryItem(r2, r3, r4);
    }

    public BitableTabAdapter(FragmentManager r42, Context r43, List<ad5.e> r44, z r46) {
        Intrinsics.checkNotNullParameter(r42, "fm");
        Intrinsics.checkNotNullParameter(r43, "mContext");
        Intrinsics.checkNotNullParameter(r44, "mTabInfoList");
        Intrinsics.checkNotNullParameter(r46, "mHomePageCreateTime");
        super(r42);
        this.a = r43;
        this.b = r44;
        this.c = r46;
        this.f = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", DiagramData$RESULT.FAIL, DiagramData$RESULT.SUCCESS, "2", "3", "4", "5", "6", "7", "8", "9"};
    }
}
