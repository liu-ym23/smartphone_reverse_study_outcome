package com.ss.android.lark.chat.chatwindow.chat.menu.reaction;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larksuite.framework.thread.ThreadUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.log.Log;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ReactionEventDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap<a, LifecycleBoundObserver> f412594a = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/menu/reaction/ReactionEventDispatcher$LifecycleBoundObserver;", "Landroidx/lifecycle/DefaultLifecycleObserver;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "observer", "Lcom/ss/android/lark/chat/chatwindow/chat/menu/reaction/ReactionEventDispatcher$ReactionEventObserver;", "<init>", "(Landroidx/lifecycle/Lifecycle;Lcom/ss/android/lark/chat/chatwindow/chat/menu/reaction/ReactionEventDispatcher$ReactionEventObserver;)V", LiveCommonConstants.REASON_ON_DEDTROY, "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "detachObserver", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LifecycleBoundObserver implements DefaultLifecycleObserver {
        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public final /* synthetic */ void onCreate(LifecycleOwner r100) {
            DefaultLifecycleObserver.CC.$default$onCreate(this, r100);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public final /* synthetic */ void onPause(LifecycleOwner r100) {
            DefaultLifecycleObserver.CC.$default$onPause(this, r100);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public final /* synthetic */ void onResume(LifecycleOwner r100) {
            DefaultLifecycleObserver.CC.$default$onResume(this, r100);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public final /* synthetic */ void onStart(LifecycleOwner r100) {
            DefaultLifecycleObserver.CC.$default$onStart(this, r100);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public final /* synthetic */ void onStop(LifecycleOwner r100) {
            DefaultLifecycleObserver.CC.$default$onStop(this, r100);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public final void onDestroy(LifecycleOwner r100) {
            Intrinsics.checkNotNullParameter(r100, "owner");
            DefaultLifecycleObserver.CC.$default$onDestroy(this, r100);
            LinkedHashMap<a, LifecycleBoundObserver> r101 = ReactionEventDispatcher.f412594a;
            Intrinsics.checkNotNullParameter(null, "observer");
            if (ReactionEventDispatcher.f412594a.remove(null) != null) goto L5;
            return;
        L5:
            throw null;
        }
    }

    public interface a {
        void a();
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f412595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f412596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Message.Type f412597c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<ReactionInfo> f412598d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f412595a, r101.f412595a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f412596b, r101.f412596b) == true) goto L15;
            return false;
        L15:
            if (this.f412597c == r101.f412597c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f412598d, r101.f412598d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f412595a.hashCode() * 31) + this.f412596b.hashCode()) * 31) + this.f412597c.hashCode()) * 31;
            List<ReactionInfo> r101 = this.f412598d;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ReactionMessage(id=" + this.f412595a + ", cid=" + this.f412596b + ", type=" + this.f412597c + ", reactionInfoList=" + this.f412598d + ')';
        }

        public final Message.Type getType() {
            return this.f412597c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(String r100, String r101, Message.Type r102, List<? extends ReactionInfo> r103) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "cid");
            Intrinsics.checkNotNullParameter(r102, "type");
            this.f412595a = r100;
            this.f412596b = r101;
            this.f412597c = r102;
            this.f412598d = r103;
        }
    }

    static {
        f412594a = new LinkedHashMap();
    }

    public static void a(String r100, f5b.b r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "reactionKey");
        Log.i("ReactionEventDispatcher", "onAddReaction, chat: " + r100 + ", msg: " + r101.getId() + ", reaction: " + r102);
        ThreadUtils.runOnUIThread(new com.ss.android.lark.chat.chatwindow.chat.menu.reaction.a(r100, new b(r101.getId(), r101.getcId(), r101.getMessage().getType(), r101.getReactionInfoList()), r102));
    }
}
