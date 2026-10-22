package com.ss.android.lark.chameleonv2.lkapi.appconfig;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/appconfig/IAppConfig$Internal$GetKeysOptions;", "Lcom/bytedance/ee/util/io/NonProguard;", "keys", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "userId", "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;)V", "getKeys", "()Ljava/util/ArrayList;", "getUserId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IAppConfig$Internal$GetKeysOptions implements NonProguard {
    private final ArrayList<String> keys;
    private final String userId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IAppConfig$Internal$GetKeysOptions copy$default(IAppConfig$Internal$GetKeysOptions r100, ArrayList r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.keys;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.userId;
    L9:
        return r100.copy(r101, r102);
    }

    public final ArrayList<String> component1() {
        return this.keys;
    }

    public final String component2() {
        return this.userId;
    }

    public final IAppConfig$Internal$GetKeysOptions copy(ArrayList<String> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        Intrinsics.checkNotNullParameter(r101, "userId");
        return new IAppConfig$Internal$GetKeysOptions(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IAppConfig$Internal$GetKeysOptions) == true) goto L8;
        return false;
    L8:
        IAppConfig$Internal$GetKeysOptions r101 = (IAppConfig$Internal$GetKeysOptions) r100;
        if (Intrinsics.areEqual(this.keys, r101.keys) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.keys.hashCode() * 31) + this.userId.hashCode();
    }

    public String toString() {
        return "GetKeysOptions(keys=" + this.keys + ", userId=" + this.userId + ')';
    }

    public final ArrayList<String> getKeys() {
        return this.keys;
    }

    public final String getUserId() {
        return this.userId;
    }

    public IAppConfig$Internal$GetKeysOptions(ArrayList<String> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        Intrinsics.checkNotNullParameter(r101, "userId");
        this.keys = r100;
        this.userId = r101;
    }
}
