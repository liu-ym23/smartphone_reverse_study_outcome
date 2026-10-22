package com.ss.android.lark.keyboard.plugin.tool.voice.vote;

import android.content.Context;
import com.larksuite.component.universe_design.button.UDButton;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule;
import com.ss.android.lark.myai.export.model.DownVoteFeedbackParam;
import com.ss.android.lark.pb.ai_engine.FeedsbackData;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.dyres.DyResUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import osb.f;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final FeedbackReasonDataConfig f430839l;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.vote.a$a, reason: collision with other inner class name */
    public static final class C5114a implements osb.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownVoteFeedbackParam f430840a;

        public C5114a(DownVoteFeedbackParam r100) {
            this.f430840a = r100;
        }

        @Override // osb.e
        public final void a(UDButton r100, FeedsbackData r101, List<String> r102) {
            Intrinsics.checkNotNullParameter(r101, "feedsBackData");
            Intrinsics.checkNotNullParameter(r102, "reasonList");
            DownVoteFeedbackParam r103 = this.f430840a;
            f r104 = r103.f432893b;
            if (r104 == null) goto L6;
            r104.a(r100, r101.mextra, r101, r103);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.vote.d
    public final void a() {
        Locale r100 = KeyboardVoiceModule.a().getCurrentLocale();
        String r101 = r100.getCountry();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L14;
        String r103 = r100.getLanguage();
        if (r103 != null) goto L15;
        r103 = "";
    L15:
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = this.f430839l.getDislikeReasons().iterator();
    L17:
        if (r105.hasNext() == false) goto L29;
        FeedbackReasonDataConfig.DislikeReason r106 = (FeedbackReasonDataConfig.DislikeReason) r105.next();
        String r107 = r106.getId();
        if (r106.getName().containsKey(r103) == false) goto L24;
        String r108 = r106.getName().get(r103);
        if (r108 != null) goto L28;
    L27:
        r108 = "";
    L28:
        r104.add(new DownVoteReasonAdapter.b(r107, r108));
        goto L17
    L24:
        if (r106.getName().containsKey(DyResUtils.ResI18n.en_US) == false) goto L27;
        r108 = r106.getName().get(DyResUtils.ResI18n.en_US);
        if (r108 != null) goto L28;
    L29:
        DownVoteReasonAdapter r109 = this.f430854h;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r104, "reasonList");
        ((ArrayList) r109.f430833b).clear();
        ((ArrayList) r109.f430833b).addAll(r104);
        r109.notifyDataSetChanged();
        return;
    L14:
        r103 = r100.getLanguage() + '_' + r100.getCountry();
        goto L15
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L10
    }

    public a(Context r100, FeedbackReasonDataConfig r101, DownVoteFeedbackParam r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "param");
        C5114a r103 = new C5114a(r102);
        super(r100, new ArrayList(), r103);
        this.f430839l = r101;
    }
}
