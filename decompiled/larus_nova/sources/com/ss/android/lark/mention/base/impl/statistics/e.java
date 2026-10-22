package com.ss.android.lark.mention.base.impl.statistics;

import com.obric.capabilitykit.EntityProvider;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import z5c.m0;

/* JADX INFO: loaded from: classes36.dex */
public final class e extends q5c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f431876a = 0;

    public static final class a {
        public a() {
        }

        public static final s5c.a a(com.ss.android.lark.mention.base.impl.atselector.bean.a r100) {
            int r101 = e.f431876a;
            if (r100 == null) goto L5;
            Chatter.ChatterType r102 = r100.f431701g;
        L7:
            if (r102 == Chatter.ChatterType.BOT) goto L18;
            if (r100 == null) goto L13;
            boolean r103 = true;
            if (r100.b() != true) goto L13;
        L14:
            if (r103 == false) goto L17;
            s5c.d.f540773o2.getClass();
            return new s5c.a(EntityProvider.KEY_ENTITY_TYPE, "ai_qa");
        L17:
            return m0.f570250d;
        L13:
            r103 = false;
            goto L14
        L18:
            return m0.f570251e;
        L5:
            r102 = null;
            goto L7
        }

        public static void b(boolean r100, String r101, String r102, boolean r103, boolean r104, String r105, String r106) {
            Intrinsics.checkNotNullParameter(r101, "atId");
            Intrinsics.checkNotNullParameter(r102, "loginUserId");
            Intrinsics.checkNotNullParameter(r105, "searchLocation");
            Intrinsics.checkNotNullParameter(r106, "guessType");
            if (r100 == false) goto L5;
            String r107 = "guess";
        L7:
            if (Intrinsics.areEqual(r101, r102) == false) goto L10;
            String r108 = "me";
        L13:
            if (r103 == false) goto L15;
            String r109 = "external";
        L16:
            if (r104 == false) goto L18;
            String r110 = "y";
        L19:
            Statistics.sendEvent("noticelist_choice", new JSONObject().put("choicetype", r107).put("notice", r108).put("member_type", r109).put("is_query", r110).put("search_location", r105).put("guess_type", r106));
            return;
        L18:
            r110 = OfficeSDKRequestTag.KEY_NEW_USER;
            goto L19
        L15:
            r109 = "internal";
            goto L16
        L10:
            if (Intrinsics.areEqual(r101, "all") == false) goto L12;
            r108 = "atall";
            goto L13
        L12:
            r108 = "atother";
            goto L13
        L5:
            r107 = "normal";
            goto L7
        }
    }

    static {
        new a();
    }
}
