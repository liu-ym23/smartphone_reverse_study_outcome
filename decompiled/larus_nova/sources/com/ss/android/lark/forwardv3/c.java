package com.ss.android.lark.forwardv3;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv3.configuration.dto.StickImage;
import com.ss.android.lark.forwardv3.dependency.ExternalForwardDirection;
import com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor;
import com.ss.android.lark.picker.base.view.binder.ICustomBinder;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements tib.g {

    public static final class a implements tib.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f425127a = null;

        static {
            f425127a = new a();
        }

        public a() {
        }

        @Override // tib.e
        public final void a() {
        }

        @Override // tib.e
        public final void b(boolean r100) {
        }

        @Override // tib.e
        public final void c() {
        }

        @Override // tib.e
        public final void d() {
        }

        @Override // tib.e
        public final void destroy() {
        }

        @Override // tib.e
        public final void e() {
        }

        @Override // tib.e
        public final void f(List<? extends SearchBaseInfo> r100) {
        }

        @Override // tib.e
        public final void g(tib.b r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
        }

        @Override // tib.e
        public final void h() {
        }

        @Override // tib.e
        public final void i(boolean r100) {
        }

        @Override // tib.e
        public final void setConsumeResultLayoutClickWhenEmpty(boolean r100) {
        }

        @Override // tib.e
        public final void setCustomBinder(ICustomBinder r100) {
            Intrinsics.checkNotNullParameter(r100, "binder");
        }
    }

    public c() {
    }

    @Override // tib.g
    public final void attachGlobalWatermark(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
    }

    @Override // tib.g
    public final String getAppLinkDomain() {
        return "";
    }

    @Override // tib.g
    public final String getCreateGroupChatResultKey() {
        return "";
    }

    @Override // tib.g
    public final String getCreateGroupSelectedDataKey() {
        return "";
    }

    @Override // tib.g
    public final zib.a getEventParams(List<String> r100) {
        return null;
    }

    @Override // tib.g
    public final String getExternalTargetId() {
        return null;
    }

    @Override // tib.g
    public final tib.a getExternalTargetItem() {
        return null;
    }

    @Override // tib.g
    public final int getLoginUserAuthorityDeniedReason() {
        return 0;
    }

    @Override // tib.g
    public final String getLoginUserId() {
        return "";
    }

    @Override // tib.g
    public final void go2Chat(Context r100, String r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chatId");
    }

    @Override // tib.g
    public final void go2Chat(Context r100, String r101, Chat.ChatMode r102, Bundle r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chatId");
        Intrinsics.checkNotNullParameter(r102, "chatMode");
    }

    @Override // tib.g
    public final void go2Thread(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "threadId");
    }

    @Override // tib.g
    public final boolean hasFilePreviewPermissionFromMessage(Message r100) {
        return true;
    }

    @Override // tib.g
    public final boolean isDoubaoWorkTabEnabled() {
        return false;
    }

    @Override // tib.g
    public final boolean isEnterSendEnabled() {
        return false;
    }

    @Override // tib.g
    public final void showNoIMPermissionDialog(String r100) {
    }

    @Override // tib.g
    public final void showSquareMessageStickerThumb(Context r100, ImageView r101, StickImage r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "imageView");
    }

    @Override // tib.g
    public final void startCreateGroup(Fragment r100, boolean r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
    }

    @Override // tib.g
    public final void startCreateGroupWithFilter(Context r100, Fragment r101, Bundle r102, IGetDataCallback<Chat> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "param");
    }

    @Override // tib.g
    public final void startProfile(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "userid");
    }

    @Override // tib.g
    public final tib.c createForwardChatPicker(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new tib.c(new View(r100), a.f425127a);
    }

    @Override // tib.g
    public final Map<String, Chatter> getChatterMap(Map<String, com.bytedance.lark.pb.basic.v1.Chatter> r100) {
        return MapsKt.emptyMap();
    }

    @Override // tib.g
    public final IExternalForwardExecutor getExternalForwardExecutor(ExternalForwardDirection r100, String r101, List<String> r102, String r103, boolean r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "direction");
        Intrinsics.checkNotNullParameter(r101, "quasiTitle");
        Intrinsics.checkNotNullParameter(r102, "messageIds");
        Intrinsics.checkNotNullParameter(r103, "sourceChatId");
        Intrinsics.checkNotNullParameter(r105, "originMergeForwardId");
        return null;
    }
}
