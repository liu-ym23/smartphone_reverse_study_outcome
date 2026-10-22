package com.larus.bmhome.chat.component.bottom.multimodal.latest;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class LatestPhotoShortcutMsgProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f299840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<String, Unit> f299841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f299842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LatestPhotoShortcutMsgProcessor$broadcastReceiver$1 f299843d;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutMsgProcessor$broadcastReceiver$1] */
    public LatestPhotoShortcutMsgProcessor(Context r100, Function1<? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "doDismiss");
        this.f299840a = r100;
        this.f299841b = r101;
        this.f299842c = CollectionsKt.listOf(new String[]{"chat.message.ACTION_SELECT_MENU_SHOW", "chat.message.ACTION_TEXT_ANSWER_SINGLE_BUTTON_CLICK", "chat.actionbar.ACTION_BAR_ITEM_CLICKED", "chat.message.PROMPT_SPAN_CLICK", "chat.message.markdown.ON_LINK_RESOLVER_INVOKE"});
        this.f299843d = new LatestPhotoShortcutMsgProcessor$broadcastReceiver$1(this);
    }
}
