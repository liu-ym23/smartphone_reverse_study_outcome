package com.ss.android.lark.chat.api.service.impl.smartreply;

import a2b.j;
import android.text.TextUtils;
import com.bytedance.lark.pb.im.v1.GetSmartAIReplyRequest;
import com.bytedance.lark.pb.im.v1.GetSmartAIReplyResponse;
import com.bytedance.lark.pb.im.v1.PushSmartAIReply;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class SmartApplyAnswerService implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b38.b f411652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<j.b> f411653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f411654c;

    public static final class a {
    }

    public interface b {
        @SdkCall(50519)
        RucketJob<GetSmartAIReplyResponse> getSmartAIReply(GetSmartAIReplyRequest r100);

        @SdkPush(50518)
        RucketJob<PushSmartAIReply> pushSmartAIReply();
    }

    static {
    }

    @Inject
    public SmartApplyAnswerService(b38.b r100) {
        Intrinsics.checkNotNullParameter(r100, "rucket");
        this.f411652a = r100;
        this.f411653b = new CopyOnWriteArrayList();
        this.f411654c = LazyKt.lazy(new SmartApplyAnswerService$service$2(this));
    }

    @Override // a2b.j
    public final MessageInfo u3(MessageInfo r100, Function0<? extends j.a> r110) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r110, "getSmartApplyAnswerDependencyLoader");
        Message r101 = r100.getMessage();
        if (r101.getAiSmartReply() != null) goto L36;
        List<ReactionInfo> r102 = r100.getReactionInfoList();
        String r103 = r101.getFromId();
        j.a r111 = r110.invoke();
        boolean r104 = false;
        if (r102 != null) goto L7;
    L34:
        if (r104 == false) goto L36;
        Log.i("SmartApplyAnswerCache", "fetch message smartReply " + r101.getId());
        Log.e("SmartApplyAnswerCache", "CoroutineScope not launch!");
        Unit r112 = Unit.INSTANCE;
        goto L36
    L7:
        if (TextUtils.isEmpty(r103) == true) goto L34;
        if (r111 == null) goto L34;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.messenger.disable_ai_nailed_it") == true) goto L34;
        List<ReactionInfo> r105 = r102;
        if ((r105 instanceof Collection) == true) goto L16;
    L18:
        Iterator<T> r106 = r105.iterator();
    L20:
        if (r106.hasNext() == false) goto L29;
        ReactionInfo r107 = (ReactionInfo) r106.next();
        if (Intrinsics.areEqual(r107.getReaction().getType(), "AINailedIt") == true) goto L24;
    L26:
        boolean r108 = false;
    L27:
        if (r108 == false) goto L20;
        boolean r109 = true;
    L30:
        if (r109 == false) goto L32;
    L33:
        r104 = true;
        goto L34
    L32:
        if (Intrinsics.areEqual(r103, r111.a()) == false) goto L34;
    L24:
        if (r107.getReactionChatters().keySet().contains(r103) == false) goto L26;
        r108 = true;
    L29:
        r109 = false;
        goto L30
    L16:
        if (r105.isEmpty() == false) goto L18;
    L36:
        return r100;
    }
}
