package com.bytedance.ee.bear.lark.aidl;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.DocFeed;
import com.bytedance.lark.pb.space.doc.v1.MGetDocFeedsRequest;
import com.bytedance.lark.pb.space.doc.v1.MGetDocFeedsResponse;
import com.bytedance.lark.pb.space.doc.v1.UpdateDocFeedRequest;
import com.bytedance.lark.pb.space.doc.v1.UpdateDocFeedResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.ChatSetting;
import com.ss.android.lark.doc.IFetchRemindCallback;
import com.ss.android.lark.doc.IPutRemindCallback;
import com.ss.android.lark.doc.IRemindStateChangeListener;
import com.ss.android.lark.doc.IReminder;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.statistics.Statistics;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yb5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class IReminderImpl extends IReminder.Stub {
    public static final int CODE_ERROR_DATA_ERROR = 1;
    public static final int CODE_ERROR_EXCEPTION = -1;
    public static final int CODE_ERROR_NET_ERROR = -2;

    public class a implements SdkSender.IParser<ibb.a> {
        public a() {
        }

        public final Object parse(byte[] r2) throws IOException {
            return d.b(((MGetDocFeedsResponse) MGetDocFeedsResponse.ADAPTER.decode(r2)).entity);
        }
    }

    public class b implements SdkSender.IParser<ChatSetting> {
        public b() {
        }

        public final Object parse(byte[] r5) throws IOException {
            UpdateDocFeedResponse r6 = (UpdateDocFeedResponse) UpdateDocFeedResponse.ADAPTER.decode(r5);
            DocFeed r7 = (DocFeed) r6.entity.doc_feeds.get(r6.doc_feed_id);
            if (r7 != null) goto L7;
            return null;
        L7:
            return new ChatSetting(r7.id, r7.is_remind.booleanValue(), System.currentTimeMillis());
        }
    }

    public IReminderImpl() {
    }

    public void registerRemindListener(IRemindStateChangeListener r3) throws RemoteException {
        if (com.bytedance.ee.bear.lark.aidl.a.b == null) goto L5;
    L14:
        RemoteCallbackList<IRemindStateChangeListener> r0 = com.bytedance.ee.bear.lark.aidl.a.b.a;
        if (r0 == null) goto L21;
        if (r3 == null) goto L22;
        r0.register(r3);
        return;
    L22:
        return;
    L21:
        return;
    L5:
        monitor-enter(com.bytedance.ee.bear.lark.aidl.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (com.bytedance.ee.bear.lark.aidl.a.b != null) goto L9;
        com.bytedance.ee.bear.lark.aidl.a.b = new com.bytedance.ee.bear.lark.aidl.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.bytedance.ee.bear.lark.aidl.a.class);     // Catch: Throwable -> L11
        goto L14
    }

    public void unRegisterRemindListener(IRemindStateChangeListener r3) throws RemoteException {
        if (com.bytedance.ee.bear.lark.aidl.a.b == null) goto L5;
    L14:
        RemoteCallbackList<IRemindStateChangeListener> r0 = com.bytedance.ee.bear.lark.aidl.a.b.a;
        if (r0 == null) goto L21;
        if (r3 == null) goto L22;
        r0.unregister(r3);
        return;
    L22:
        return;
    L21:
        return;
    L5:
        monitor-enter(com.bytedance.ee.bear.lark.aidl.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (com.bytedance.ee.bear.lark.aidl.a.b != null) goto L9;
        com.bytedance.ee.bear.lark.aidl.a.b = new com.bytedance.ee.bear.lark.aidl.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.bytedance.ee.bear.lark.aidl.a.class);     // Catch: Throwable -> L11
        goto L14
    }

    private void loadFromService(final String r3, final IFetchRemindCallback r4) {
        pullChatSettings(new AnonymousClass1(this, r3), new AnonymousClass2(this, r3, r4));
    }

    private void pullChatSettings(LinkedList<String> r2, final IGetDataCallback<Map<String, ChatSetting>> r3) {
        pullDocFeeds(r2, new AnonymousClass5(this, r3));
    }

    private void pullDocFeeds(List<String> r3, IGetDataCallback<ibb.a> r4) {
        MGetDocFeedsRequest.Builder r5 = new MGetDocFeedsRequest.Builder().ids(r3);
        SdkSender.asynSendRequestNonWrap(Command.MGET_DOC_FEEDS, r5, r4, new a());
    }

    public void getRemindState(String r1, IFetchRemindCallback r2) throws RemoteException {
        loadFromService(r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        if (r2 == null) goto L9;
        r2.onFaile(-1);
        return;
    }

    private void patchRemind(final String r2, boolean r3, final IPutRemindCallback r4) {
        patchChatSetting(r2, r3, new AnonymousClass3(this, r4, r2));
    }

    public void patchChatSetting(String r2, boolean r3, IGetDataCallback<ChatSetting> r4) {
        UpdateDocFeedRequest.Builder r0 = new UpdateDocFeedRequest.Builder();
        r0.doc_feed_id(r2).is_remind(Boolean.valueOf(r3));
        SdkSender.asynSendRequestNonWrap(Command.UPDATE_DOC_FEED, r0, r4, new b());
    }

    public void setRemind(String r6, boolean r7, IPutRemindCallback r8) throws RemoteException {
        patchRemind(r6, r7, r8);
        if (r7 == false) goto L5;
        int r9 = kbb.a.a;
        Intrinsics.checkNotNullParameter("doc", "chatType");
        Statistics.sendEvent("chat_unmute", new JSONObject().put("chat_type", "doc").put("set_from", "chat_setting").put("chat_id", r6));
        return;
    L5:
        int r10 = kbb.a.a;
        Intrinsics.checkNotNullParameter("doc", "chatType");
        Statistics.sendEvent("chat_mute", new JSONObject().put("chat_type", "doc").put("set_from", "chat_setting").put("chat_id", r6));
    }
}
