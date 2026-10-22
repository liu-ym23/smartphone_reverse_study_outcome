package com.bytedance.supervisor.token;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \n2\u00020\u0001:\u0001\u0003R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/supervisor/token/Token;", "Landroid/os/Parcelable;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", LocationMonitorConst.IDENTIFIER, "CREATOR", "token_release"}, k = 1, mv = {1, 5, 1})
public final class Token implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f270346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f270347b;

    public static final class a implements Parcelable.Creator<Token> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Token createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Token r101 = new Token(String.valueOf(r100.readString()));
            r100.readMap(r101.f270347b, Map.class.getClassLoader());
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final Token[] newArray(int r100) {
            return new Token[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getIdentifier() {
        return this.f270346a;
    }

    public Token(String r100) {
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        this.f270346a = r100;
        this.f270347b = new LinkedHashMap();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        r100.writeString(this.f270346a);
        r100.writeMap(this.f270347b);
    }
}
