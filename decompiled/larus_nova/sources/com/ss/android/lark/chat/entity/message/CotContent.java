package com.ss.android.lark.chat.entity.message;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006$"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/CotContent;", "Ljava/io/Serializable;", "cotId", "", "events", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chat/entity/message/CotEvent;", "Lkotlin/collections/ArrayList;", "status", "Lcom/ss/android/lark/chat/entity/message/CotStatus;", "violated", "", "cotEventsIncomplete", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;Lcom/ss/android/lark/chat/entity/message/CotStatus;ZZ)V", "getCotId", "()Ljava/lang/String;", "getEvents", "()Ljava/util/ArrayList;", "getStatus", "()Lcom/ss/android/lark/chat/entity/message/CotStatus;", "getViolated", "()Z", "getCotEventsIncomplete", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CotContent implements Serializable {
    private final boolean cotEventsIncomplete;
    private final String cotId;
    private final ArrayList<CotEvent> events;
    private final CotStatus status;
    private final boolean violated;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CotContent copy$default(CotContent r100, String r101, ArrayList r102, CotStatus r103, boolean r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.cotId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.events;
    L8:
        ArrayList r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.status;
    L11:
        CotStatus r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.violated;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.cotEventsIncomplete;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.cotId;
    }

    public final ArrayList<CotEvent> component2() {
        return this.events;
    }

    public final CotStatus component3() {
        return this.status;
    }

    public final boolean component4() {
        return this.violated;
    }

    public final boolean component5() {
        return this.cotEventsIncomplete;
    }

    public final CotContent copy(String r100, ArrayList<CotEvent> r101, CotStatus r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "cotId");
        Intrinsics.checkNotNullParameter(r101, "events");
        Intrinsics.checkNotNullParameter(r110, "status");
        return new CotContent(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CotContent) == true) goto L8;
        return false;
    L8:
        CotContent r101 = (CotContent) r100;
        if (Intrinsics.areEqual(this.cotId, r101.cotId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.events, r101.events) == true) goto L15;
        return false;
    L15:
        if (this.status == r101.status) goto L18;
        return false;
    L18:
        if (this.violated == r101.violated) goto L21;
        return false;
    L21:
        if (this.cotEventsIncomplete == r101.cotEventsIncomplete) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.cotId.hashCode() * 31) + this.events.hashCode()) * 31) + this.status.hashCode()) * 31;
        int r101 = 1231;
        if (this.violated == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.cotEventsIncomplete == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "CotContent(cotId=" + this.cotId + ", events=" + this.events + ", status=" + this.status + ", violated=" + this.violated + ", cotEventsIncomplete=" + this.cotEventsIncomplete + ')';
    }

    public final boolean getCotEventsIncomplete() {
        return this.cotEventsIncomplete;
    }

    public final String getCotId() {
        return this.cotId;
    }

    public final ArrayList<CotEvent> getEvents() {
        return this.events;
    }

    public final CotStatus getStatus() {
        return this.status;
    }

    public final boolean getViolated() {
        return this.violated;
    }

    public CotContent(String r100, ArrayList<CotEvent> r101, CotStatus r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "cotId");
        Intrinsics.checkNotNullParameter(r101, "events");
        Intrinsics.checkNotNullParameter(r102, "status");
        this.cotId = r100;
        this.events = r101;
        this.status = r102;
        this.violated = r103;
        this.cotEventsIncomplete = r104;
    }
}
