package com.larus.bmhome.chat.require;

import android.content.Context;
import android.os.Bundle;
import com.larus.bmhome.chat.bean.PageType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\rJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\tH&¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/require/IMainBotService;", "", "openMainBot", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "param", "Lcom/larus/bmhome/chat/require/IMainBotService$MainBotParam;", "isEnableDouYinSdk", "", "getSearchSceneId", "", "isEnableDouyinFeedCocoEntrance", "MainBotParam", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMainBotService {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f308537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f308538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Integer> f308539c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f308540d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f308541e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f308542f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Integer f308543g;

        public a(Bundle r100, int r101, List<Integer> r102, int r103, int r104, int r105, Integer r106) {
            Intrinsics.checkNotNullParameter(r100, "bundle");
            Intrinsics.checkNotNullParameter(r102, "pageList");
            this.f308537a = r100;
            this.f308538b = r101;
            this.f308539c = r102;
            this.f308540d = r103;
            this.f308541e = r104;
            this.f308542f = r105;
            this.f308543g = r106;
        }

        public /* synthetic */ a(Bundle r110, int r111, List r112, int r113, int r114, int r115, Integer r116, int r117) {
            if ((r117 & 2) == 0) goto L5;
            int r100 = PageType.Chat.getType();
        L7:
            if ((r117 & 4) == 0) goto L9;
            List r101 = CollectionsKt.emptyList();
        L11:
            if ((r117 & 8) == 0) goto L13;
            int r102 = 0;
        L15:
            if ((r117 & 64) == 0) goto L17;
            Integer r103 = null;
        L18:
            this(r110, r100, r101, r102, r114, r115, r103);
            return;
        L17:
            r103 = r116;
            goto L18
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }
    }

    String a();

    boolean b();

    void c(Context r100, a r101);
}
