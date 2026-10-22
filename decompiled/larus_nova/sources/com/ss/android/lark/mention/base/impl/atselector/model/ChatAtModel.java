package com.ss.android.lark.mention.base.impl.atselector.model;

import android.text.TextUtils;
import ccb.d;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v1.GetMentionChatterSensitiveInfoRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.callback.UIGetContinualDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatterSensitiveInfo;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.MentionUtils;
import com.ss.android.lark.mention.base.impl.atselector.AtPresenter;
import com.ss.android.lark.mention.base.impl.atselector.bean.AllAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.AtSelectInitData;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.SearchBean;
import com.ss.android.lark.mention.base.impl.atselector.model.loader.RecommendDataLoader;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.o;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes36.dex */
public final class ChatAtModel extends BaseAtModel {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecommendDataLoader f431780i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Chat f431781j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f431782k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f431783l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f431784m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f431785n;

    /* JADX INFO: renamed from: com.ss.android.lark.mention.base.impl.atselector.model.ChatAtModel$3, reason: invalid class name */
    class AnonymousClass3 implements IGetDataCallback<d> {
        final /* synthetic */ ChatAtModel this$0;
        final /* synthetic */ IGetDataCallback val$callback;
        final /* synthetic */ String val$requestID;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.larksuite.framework.callback.IGetDataCallback
        public void onError(ErrorResult r100) {
            if (this.this$0.f431779h.equals(this.val$requestID) == true) goto L5;
            return;
        L5:
            IGetDataCallback r101 = this.val$callback;
            if (r101 == null) goto L9;
            r101.onError(r100);
            return;
        }

        public void onSuccess(d r100) {
            if (this.this$0.f431779h.equals(this.val$requestID) == true) goto L5;
            return;
        L5:
            IGetDataCallback r101 = this.val$callback;
            if (r101 == null) goto L9;
            r101.onSuccess(r100);
            return;
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
            onError(r100);
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
            onSuccess((d) r100);
        }

        public AnonymousClass3(ChatAtModel r100, String r101, IGetDataCallback r102) {
            this.this$0 = r100;
            this.val$requestID = r101;
            this.val$callback = r102;
        }
    }

    public class a extends aqb.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatAtModel f431786a;

        public a(ChatAtModel r100) {
            this.f431786a = r100;
        }

        @Override // aqb.a, m6b.o
        public final void onPushChat(Chat r100) {
            ChatAtModel r101 = this.f431786a;
            r101.getClass();
            if (r100.getId().equals(r101.f431772a) == true) goto L5;
            return;
        L5:
            if (r100.isP2PChat() == true) goto L20;
            Chat.AtAllPermission r102 = r100.getAtAllPermission();
            if (MentionUtils.d(r100) == false) goto L10;
            return;
        L10:
            if (r102 != Chat.AtAllPermission.ALL_MEMBERS) goto L13;
            com.ss.android.lark.mention.base.impl.atselector.d.a r103 = r101.f431773b;
            final List<BaseAtBean> r104 = r101.f431775d;
            final AtPresenter.a r105 = (AtPresenter.a) r103;
            r105.getClass();
            final boolean r106 = true;
            UICallbackExecutor.execute(new com.ss.android.lark.mention.base.impl.atselector.a(r105, r104, r106));
            return;
        L13:
            if (r102 != Chat.AtAllPermission.ONLY_OWNER) goto L19;
            com.ss.android.lark.mention.base.impl.atselector.d.a r107 = r101.f431773b;
            final List<BaseAtBean> r108 = r101.f431775d;
            final AtPresenter.a r109 = (AtPresenter.a) r107;
            r109.getClass();
            final boolean r110 = false;
            UICallbackExecutor.execute(new com.ss.android.lark.mention.base.impl.atselector.a(r109, r108, r110));
            return;
        L19:
            return;
        }
    }

    @Override // com.larksuite.framework.mvp.BaseModel, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        arb.a.f16068b.V(String.valueOf(hashCode()), this.f431772a);
        super.destroy();
    }

    public final boolean p() {
        if (this.f431774c.getIsInterruptAtAll() == false) goto L5;
    L13:
        return false;
    L5:
        if (s() == null) goto L13;
        if (s().getType() != Chat.Type.GROUP) goto L13;
        int r100 = MentionUtils.f431660a;
        if (MentionUtils.d(s()) == false) goto L11;
    L12:
        return true;
    L11:
        if (s().getAtAllPermission() != Chat.AtAllPermission.ALL_MEMBERS) goto L13;
        goto L12
    }

    public final Chat s() {
        Chat r100 = this.f431781j;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (TextUtils.isEmpty(this.f431772a) == false) goto L10;
        return null;
    L10:
        return ImSdkService.b().we(this.f431772a);
    }

    public final List<BaseAtBean> w() {
        if (CollectionUtils.isEmpty(this.f431775d) == true) goto L5;
        Iterator<BaseAtBean> r100 = this.f431775d.iterator();
    L8:
        if (r100.hasNext() == false) goto L13;
        String r101 = r100.next().getId();
        Pattern r102 = o.f444744a;
        if (r101.equals("all") == false) goto L8;
        r100.remove();
    L13:
        return this.f431775d;
    L5:
        return new ArrayList();
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.d
    public final boolean T0() {
        Chat r100 = s();
        boolean r101 = FeatureGatingModule.getFeatureGatingService().isEnable("group.mention.new.tips");
        if (r100 != null) goto L5;
    L10:
        return false;
    L5:
        if (r100.getChatMode() != Chat.ChatMode.THREAD_V2) goto L10;
        if (r100.isPublic() == false) goto L10;
        if (r101 == false) goto L10;
        return true;
    }

    @Override // com.larksuite.framework.mvp.BaseModel, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        this.f431780i = new RecommendDataLoader(this.f431772a, this.f431782k, this.f431784m, this.f431783l);
        arb.a.f16068b.c0(String.valueOf(hashCode()), this.f431772a, this.f431785n);
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new com.ss.android.lark.mention.base.impl.atselector.model.a(this));
    }

    public final List<BaseAtBean> o() {
        if (p() == true) goto L7;
        return this.f431775d;
    L7:
        if (CollectionUtils.isEmpty(this.f431775d) == true) goto L9;
        HashMap r100 = new HashMap();
        Iterator r101 = ((ArrayList) this.f431775d).iterator();
    L12:
        if (r101.hasNext() == false) goto L14;
        BaseAtBean r102 = (BaseAtBean) r101.next();
        r100.put(r102.getId(), r102);
        goto L12
    L14:
        Chat r103 = s();
        if (r103 != null) goto L17;
    L19:
        int r104 = 0;
    L20:
        Pattern r105 = o.f444744a;
        if (r100.containsKey("all") == true) goto L24;
        ListProtector.add(this.f431775d, 0, new AllAtBean(r104));
    L24:
        return this.f431775d;
    L17:
        if (this.f431784m == false) goto L19;
        r104 = r103.getUserCount();
        goto L20
    L9:
        return new ArrayList();
    }

    public ChatAtModel(AtSelectInitData r100) {
        super(r100);
        this.f431785n = new a(this);
        this.f431772a = r100.getChannelId();
        this.f431782k = r100.isEnableMyAI();
        this.f431784m = r100.isUserCountVisible();
        this.f431783l = r100.isEnableAIKnowledge();
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.d
    public final void U7(final IGetDataCallback<List<BaseAtBean>> r100) {
        Log.i("ChatAtModel", "start loadRecommendData, channelId: " + this.f431772a);
        UIGetContinualDataCallback r101 = new UIGetContinualDataCallback(new AnonymousClass2(this, r100));
        RecommendDataLoader r102 = this.f431780i;
        IGetDataCallback r103 = (IGetDataCallback) getCallbackManager().wrapAndAddCallback(r101);
        r102.getClass();
        RxScheduledExecutor.justInIO(new com.ss.android.lark.mention.base.impl.atselector.model.loader.b(r102, r103));
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.d
    public final void d1(Map<String, ChatterSensitiveInfo> r100, List<BaseAtBean> r101) {
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (CollectionUtils.isEmpty(r101) == true) goto L32;
        Iterator<BaseAtBean> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L33;
        BaseAtBean r103 = r102.next();
        if ((r103 instanceof SearchBean) == false) goto L9;
        com.ss.android.lark.mention.base.impl.atselector.bean.a r104 = ((SearchBean) r103).getChatterInfo();
        if (r104 == null) goto L9;
        if (r100.containsKey(r104.f431695a) == false) goto L19;
        if (r100.get(r104.f431695a) == null) goto L19;
        r104.f431711q = r100.get(r104.f431695a);
    L19:
        Log.e("ChatAtModel", "chatterId2SensitiveInfo not contains key: " + r104.f431695a);
        goto L9
    L33:
        return;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.d
    public final void N2(String r110, String r111, IGetDataCallback<d> r112) {
        StringBuilder r100 = new StringBuilder("netSearch, searchKey length: ");
        if (r110 == null) goto L5;
        int r101 = r110.length();
    L6:
        r100.append(r101);
        r100.append(", requestID: ");
        r100.append(r111);
        Log.i("ChatAtModel", r100.toString());
        this.f431778g = r110;
        this.f431779h = r111;
        ChatService.c.f411535a.m(this.f431772a, r110, r111, true, this.f431783l, getCallbackManager().wrapAndAddGetDataCallback(new AnonymousClass3(this, r111, r112)));
        return;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.d
    public final void m2(List r100, final String r101, IGetDataCallback r102) {
        if (CollectionUtils.isEmpty(r100) == false) goto L6;
        Log.e("ChatAtModel", "beanList is null or empty");
        return;
    L6:
        final ArrayList r103 = new ArrayList();
        Iterator r104 = r100.iterator();
    L8:
        if (r104.hasNext() == false) goto L22;
        BaseAtBean r105 = (BaseAtBean) r104.next();
        if ((r105 instanceof SearchBean) == false) goto L8;
        SearchBean r106 = (SearchBean) r105;
        if (r106.getChatterInfo() == null) goto L8;
        if (r106.getChatterInfo().b() == true) goto L8;
        Long r107 = CastLongProtector.valueOf(r106.getChatterInfo().f431695a);     // Catch: Throwable -> L18
    L20:
        r103.add(r107);
    L18:
        th = move-exception;
        Log.e("ChatAtModel", th);
        r107 = null;
        goto L20
    L22:
        if (CollectionUtils.isEmpty(r103) == false) goto L25;
        Log.e("ChatAtModel", "beanList is null or empty");
        return;
    L25:
        Log.i("ChatAtModel", "request chatter ids size: " + r103.size());
        GetMentionChatterSensitiveInfoRequest.Builder r108 = new GetMentionChatterSensitiveInfoRequest.Builder();
        r108.strategy(SyncDataStrategy.FORCE_SERVER);
        r108.chatter_ids(r103);
        SdkSender.asynSendRequestNonWrap(Command.GET_MENTION_CHATTER_SENSITIVE_INFO, r108, r101, r102, new b(this, r103, r101));
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.d
    public final void z1(String r110, String r111, IGetDataCallback<d> r112) {
        StringBuilder r100 = new StringBuilder("localSearch, searchKey length: ");
        if (r110 == null) goto L5;
        int r101 = r110.length();
    L6:
        r100.append(r101);
        r100.append(", requestID: ");
        r100.append(r111);
        Log.i("ChatAtModel", r100.toString());
        this.f431778g = r110;
        this.f431779h = r111;
        ChatService.c.f411535a.m(this.f431772a, r110, r111, false, this.f431783l, getCallbackManager().wrapAndAddGetDataCallback(new AnonymousClass3(this, r111, r112)));
        return;
    L5:
        r101 = 0;
        goto L6
    }
}
