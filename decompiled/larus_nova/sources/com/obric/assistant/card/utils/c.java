package com.obric.assistant.card.utils;

import android.os.Parcelable;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.capabilitykit.common.CardProvider;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c {
    public static final Object b(AppIntentCardData r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.getType();
        if (r101 != 0) goto L5;
        return r100;
    L5:
        if (r101 == 1) goto L8;
        FLogger.f375446a.w("AppIntentMessageEx", "AppIntentCardData.innerData unknown type " + r100.getType());
    L12:
        return null;
    L8:
        CardProvider r102 = r100.getCardProvider();
        if (r102 != null) goto L13;
        FLogger.f375446a.w("AppIntentMessageEx", "AppIntentCardData.innerData no cardProvider");
        goto L12
    L13:
        return r102;
    }

    public static final Object c(AppIntentCardData r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.getType();
        if (r101 != 0) goto L5;
        Object r102 = r100.getAppEntity();
        if (r102 != null) goto L17;
        FLogger.f375446a.w("AppIntentMessageEx", "AppIntentCardData.innerData no appEntity");
        return null;
    L17:
        return r102;
    L5:
        if (r101 == 1) goto L7;
        FLogger.f375446a.w("AppIntentMessageEx", "AppIntentCardData.innerData unknown type " + r100.getType());
        return null;
    L7:
        r102 = r100.getCardProvider();
        if (r102 != null) goto L17;
        FLogger.f375446a.w("AppIntentMessageEx", "AppIntentCardData.innerData no cardProvider");
        return null;
    }

    public static final List<Parcelable> d(AppIntentMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getDataV2() == null) goto L7;
        return r100.getDataV2();
    L7:
        return r100.getData();
    }

    public static final MessageExtraForViewHolder a(AppIntentMessage r100, Message r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r110, "message");
        boolean r101 = r100.isPaused();
        boolean r102 = r100.getShowRecentContact();
        String r103 = r100.getDataSource().getSourceIntent();
        String r104 = r100.getDataSource().getIntentName();
        String r105 = r110.getLocalMessageId();
        if (r105 != null) goto L6;
        r105 = "";
    L6:
        return new MessageExtraForViewHolder(r101, r102, r103, r104, r105, r100.getExt(), r110.getExt());
    }
}
