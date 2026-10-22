package com.larus.im.bean.message;

import com.tencent.connect.common.Constants;
import java.lang.annotation.Annotation;
import java.util.List;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import nuc.i0;
import yc9.h0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/larus/im/bean/message/MessageTag;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "MessageTag_Unknown", "MessageTag_Onboarding_FIRSTMEG", "MessageTag_OnboardingV2", "MessageTag_ASR", "MessageTag_Edit", "MessageTag_Onboarding_WELCOMEBACK", "MessageTag_Onboarding_LONG_TIME_NO_SEE", "MessageTag_Bot_Task", "MessageTag_OP_Cron_Push", "MessageTag_HideInConvList", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum MessageTag extends Enum<MessageTag> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MessageTag[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final a Companion = null;

    @SerialName("3")
    public static final MessageTag MessageTag_ASR = null;

    @SerialName("6")
    public static final MessageTag MessageTag_Bot_Task = null;

    @SerialName("4")
    public static final MessageTag MessageTag_Edit = null;

    @SerialName(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)
    public static final MessageTag MessageTag_HideInConvList = null;

    @SerialName("7")
    public static final MessageTag MessageTag_OP_Cron_Push = null;

    @SerialName("2")
    public static final MessageTag MessageTag_OnboardingV2 = null;

    @SerialName("1")
    public static final MessageTag MessageTag_Onboarding_FIRSTMEG = null;

    @SerialName("8")
    public static final MessageTag MessageTag_Onboarding_LONG_TIME_NO_SEE = null;

    @SerialName("5")
    public static final MessageTag MessageTag_Onboarding_WELCOMEBACK = null;

    @SerialName("0")
    public static final MessageTag MessageTag_Unknown = null;
    public final int value;

    public static final class a {
        public a() {
        }

        public final d<MessageTag> serializer() {
            return (d) MessageTag.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public static boolean a(List r100) {
            if (r100 != null) goto L4;
        L6:
            return false;
        L4:
            if (r100.contains(Integer.valueOf(MessageTag.MessageTag_HideInConvList.value)) != true) goto L6;
            return true;
        }

        public static MessageTag b(List r100) {
            if (r100 == null) goto L4;
            MessageTag r101 = MessageTag.MessageTag_Onboarding_FIRSTMEG;
            if (r100.contains(Integer.valueOf(r101.value)) == false) goto L8;
            return r101;
        L8:
            MessageTag r102 = MessageTag.MessageTag_Onboarding_WELCOMEBACK;
            if (r100.contains(Integer.valueOf(r102.value)) == false) goto L11;
            return r102;
        L11:
            MessageTag r103 = MessageTag.MessageTag_OnboardingV2;
            if (r100.contains(Integer.valueOf(r103.value)) == false) goto L14;
            return r103;
        L14:
            MessageTag r104 = MessageTag.MessageTag_Onboarding_LONG_TIME_NO_SEE;
            if (r100.contains(Integer.valueOf(r104.value)) == false) goto L18;
            return r104;
        L18:
            return MessageTag.MessageTag_Unknown;
        L4:
            return MessageTag.MessageTag_Unknown;
        }
    }

    private static final /* synthetic */ MessageTag[] $values() {
        return new MessageTag[]{MessageTag_Unknown, MessageTag_Onboarding_FIRSTMEG, MessageTag_OnboardingV2, MessageTag_ASR, MessageTag_Edit, MessageTag_Onboarding_WELCOMEBACK, MessageTag_Onboarding_LONG_TIME_NO_SEE, MessageTag_Bot_Task, MessageTag_OP_Cron_Push, MessageTag_HideInConvList};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<MessageTag> getEntries() {
        return $ENTRIES;
    }

    static {
        MessageTag_Unknown = new MessageTag("MessageTag_Unknown", 0, 0);
        MessageTag_Onboarding_FIRSTMEG = new MessageTag("MessageTag_Onboarding_FIRSTMEG", 1, 1);
        MessageTag_OnboardingV2 = new MessageTag("MessageTag_OnboardingV2", 2, 2);
        MessageTag_ASR = new MessageTag("MessageTag_ASR", 3, 3);
        MessageTag_Edit = new MessageTag("MessageTag_Edit", 4, 4);
        MessageTag_Onboarding_WELCOMEBACK = new MessageTag("MessageTag_Onboarding_WELCOMEBACK", 5, 5);
        MessageTag_Onboarding_LONG_TIME_NO_SEE = new MessageTag("MessageTag_Onboarding_LONG_TIME_NO_SEE", 6, 8);
        MessageTag_Bot_Task = new MessageTag("MessageTag_Bot_Task", 7, 6);
        MessageTag_OP_Cron_Push = new MessageTag("MessageTag_OP_Cron_Push", 8, 7);
        MessageTag_HideInConvList = new MessageTag("MessageTag_HideInConvList", 9, 10);
        MessageTag[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new h0());
    }

    public static MessageTag[] values() {
        return (MessageTag[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.bean.message.MessageTag", values(), new String[]{"0", "1", "2", "3", "4", "5", "8", "6", "7", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static MessageTag valueOf(String r100) {
        return (MessageTag) r27.a.a(MessageTag.class, r100);
    }

    private MessageTag(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
