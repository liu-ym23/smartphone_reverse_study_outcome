package com.ss.android.lark.chat.name;

import android.util.LruCache;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.api.service.ITranslateService;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.translate.dialog.MoreTranslateActionDialog;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import jdb.g;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import z5c.r;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IChatService f415943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ITranslateService f415944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f415945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f415946d;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.name.a$a, reason: collision with other inner class name */
    public static final class C4866a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f415947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<MoreTranslateActionDialog> f415948b;

        public b(String r100, MoreTranslateActionDialog r101) {
            Intrinsics.checkNotNullParameter(r100, "chatId");
            Intrinsics.checkNotNullParameter(r101, "dialog");
            this.f415947a = r100;
            this.f415948b = new WeakReference(r101);
        }
    }

    static {
    }

    @Inject
    public a(IChatService r100, ITranslateService r101, g r102) {
        Intrinsics.checkNotNullParameter(r100, "chatService");
        Intrinsics.checkNotNullParameter(r101, "translateService");
        Intrinsics.checkNotNullParameter(r102, "fgService");
        this.f415943a = r100;
        this.f415944b = r101;
        this.f415945c = r102;
        new LruCache(20);
    }

    public static void a(s5c.a r100, Chat r101, Map r102) {
        Map r103 = ChatParamUtils.b(r101, null, 6);
        LinkedHashMap r104 = new LinkedHashMap();
        s5c.a r105 = r.f570317c;
        r104.put("click", r100.f540772b);
        r104.putAll(r103);
        if (r102 == null) goto L5;
        r104.putAll(r102);
    L5:
        Statistics.sendEvent("im_chat_main_click", new JSONObject(r104));
    }
}
