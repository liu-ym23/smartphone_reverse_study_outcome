package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.y1;

/* JADX INFO: loaded from: classes25.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f298938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f298939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f298940c;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f298941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f298942b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f298943c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f298944d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f298945e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f298941a, r101.f298941a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f298942b, r101.f298942b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f298943c, r101.f298943c) == true) goto L18;
            return false;
        L18:
            if (this.f298944d == r101.f298944d) goto L21;
            return false;
        L21:
            if (this.f298945e == r101.f298945e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f298941a.hashCode() * 31) + this.f298942b.hashCode()) * 31) + this.f298943c.hashCode()) * 31;
            if (this.f298944d == false) goto L5;
            int r101 = 1231;
        L7:
            return ((r100 + r101) * 31) + this.f298945e;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "OptionTrace(mentionType=" + this.f298941a + ", itemType=" + this.f298942b + ", itemName=" + this.f298943c + ", isSearchResult=" + this.f298944d + ", index=" + this.f298945e + ')';
        }

        public b(String r100, String r101, String r102, boolean r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, "mentionType");
            Intrinsics.checkNotNullParameter(r101, "itemType");
            Intrinsics.checkNotNullParameter(r102, "itemName");
            this.f298941a = r100;
            this.f298942b = r101;
            this.f298943c = r102;
            this.f298944d = r103;
            this.f298945e = r104;
        }
    }

    static {
    }

    public static String a(b r100) {
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(new Object[]{"mention_panel_option", r100.f298941a, r100.f298942b, r100.f298943c, Boolean.valueOf(r100.f298944d), Integer.valueOf(r100.f298945e)}), ":", null, null, 0, null, null, 62, null);
    }

    public final h0 b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mentionType");
        return new h0(r100, "more", this.f298938a.getString(R.string.larus_LarkIM_Search_ViewMoreInTab_Button));
    }

    public final void c(b r100) {
        if (this.f298939b.invoke().booleanValue() == true) goto L5;
        return;
    L5:
        String r101 = r100.f298941a;
        String r102 = r100.f298942b;
        String r103 = r100.f298943c;
        boolean r104 = r100.f298944d;
        Intrinsics.checkNotNullParameter("chat", "currentPage");
        Intrinsics.checkNotNullParameter("", "skillId");
        Intrinsics.checkNotNullParameter(r101, "mentionType");
        Intrinsics.checkNotNullParameter(r102, "itemType");
        Intrinsics.checkNotNullParameter(r103, "itemName");
        JSONObject r105 = y1.a(r101, r103, r104);
        r105.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r102);
        y1.b("mention_panel_option_click", r105);
    }

    public final void d(b r100) {
        if (this.f298939b.invoke().booleanValue() == true) goto L5;
        return;
    L5:
        String r101 = r100.f298941a;
        String r102 = r100.f298942b;
        String r103 = r100.f298943c;
        boolean r104 = r100.f298944d;
        int r105 = r100.f298945e;
        Intrinsics.checkNotNullParameter("chat", "currentPage");
        Intrinsics.checkNotNullParameter("", "skillId");
        Intrinsics.checkNotNullParameter(r101, "mentionType");
        Intrinsics.checkNotNullParameter(r102, "itemType");
        Intrinsics.checkNotNullParameter(r103, "itemName");
        JSONObject r106 = y1.a(r101, r103, r104);
        r106.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r102);
        r106.put("index", r105);
        y1.b("mention_panel_option_show", r106);
    }

    public m0(Context r100, n r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "shouldTrack");
        this.f298938a = r100;
        this.f298939b = r101;
    }
}
