package com.ss.android.lark.chameleonv2.lkapi.transport.command;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0011J@\u0010\u0016\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0006\u0010\u000eR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyMGetChattersRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "chatterIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isFromServer", "", "syncDataStrategy", "", "<init>", "(Ljava/util/ArrayList;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getChatterIds", "()Ljava/util/ArrayList;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSyncDataStrategy", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/util/ArrayList;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyMGetChattersRequest;", "equals", "other", "", "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyMGetChattersRequest implements NonProguard {
    private final ArrayList<String> chatterIds;
    private final Boolean isFromServer;
    private final Integer syncDataStrategy;

    public MyMGetChattersRequest() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MyMGetChattersRequest copy$default(MyMGetChattersRequest r100, ArrayList r101, Boolean r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.chatterIds;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.isFromServer;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.syncDataStrategy;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final ArrayList<String> component1() {
        return this.chatterIds;
    }

    public final Boolean component2() {
        return this.isFromServer;
    }

    public final Integer component3() {
        return this.syncDataStrategy;
    }

    public final MyMGetChattersRequest copy(ArrayList<String> r100, Boolean r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "chatterIds");
        return new MyMGetChattersRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MyMGetChattersRequest) == true) goto L8;
        return false;
    L8:
        MyMGetChattersRequest r101 = (MyMGetChattersRequest) r100;
        if (Intrinsics.areEqual(this.chatterIds, r101.chatterIds) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isFromServer, r101.isFromServer) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.syncDataStrategy, r101.syncDataStrategy) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.chatterIds.hashCode() * 31;
        Boolean r101 = this.isFromServer;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.syncDataStrategy;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "MyMGetChattersRequest(chatterIds=" + this.chatterIds + ", isFromServer=" + this.isFromServer + ", syncDataStrategy=" + this.syncDataStrategy + ')';
    }

    public final ArrayList<String> getChatterIds() {
        return this.chatterIds;
    }

    public final Integer getSyncDataStrategy() {
        return this.syncDataStrategy;
    }

    public final Boolean isFromServer() {
        return this.isFromServer;
    }

    public MyMGetChattersRequest(ArrayList<String> r100, Boolean r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "chatterIds");
        this.chatterIds = r100;
        this.isFromServer = r101;
        this.syncDataStrategy = r102;
    }

    public /* synthetic */ MyMGetChattersRequest(ArrayList r100, Boolean r101, Integer r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = Boolean.FALSE;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 1;
    L11:
        this(r100, r101, r102);
    }
}
