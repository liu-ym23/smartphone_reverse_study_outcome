package com.larus.audio.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.honorid.core.data.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003JO\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0006\u0010(\u001a\u00020)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020)HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020)R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00065"}, d2 = {"Lcom/larus/audio/bean/GetMatchVoiceRequest;", "Landroid/os/Parcelable;", "botName", "", "botDesc", "voiceId", "botId", "botModelType", "", UserInfo.LANGUAGECODE, "scene", "Lcom/larus/audio/bean/RecommendScene;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/larus/audio/bean/RecommendScene;)V", "getBotName", "()Ljava/lang/String;", "setBotName", "(Ljava/lang/String;)V", "getBotDesc", "setBotDesc", "getVoiceId", "setVoiceId", "getBotId", "setBotId", "getBotModelType", "()J", "setBotModelType", "(J)V", "getLanguageCode", "setLanguageCode", "getScene", "()Lcom/larus/audio/bean/RecommendScene;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetMatchVoiceRequest implements Parcelable {
    public static final Parcelable.Creator<GetMatchVoiceRequest> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f288717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f288718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f288719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f288720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f288721e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f288722f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RecommendScene f288723g;

    public static final class a implements Parcelable.Creator<GetMatchVoiceRequest> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GetMatchVoiceRequest createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new GetMatchVoiceRequest(r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readLong(), r110.readString(), RecommendScene.valueOf(r110.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public final GetMatchVoiceRequest[] newArray(int r100) {
            return new GetMatchVoiceRequest[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public GetMatchVoiceRequest() {
        this(null, null, null, null, 0, null, null, 127);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetMatchVoiceRequest) == true) goto L8;
        return false;
    L8:
        GetMatchVoiceRequest r101 = (GetMatchVoiceRequest) r100;
        if (Intrinsics.areEqual(this.f288717a, r101.f288717a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f288718b, r101.f288718b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f288719c, r101.f288719c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f288720d, r101.f288720d) == true) goto L21;
        return false;
    L21:
        if (this.f288721e == r101.f288721e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f288722f, r101.f288722f) == true) goto L27;
        return false;
    L27:
        if (this.f288723g == r101.f288723g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f288717a.hashCode() * 31) + this.f288718b.hashCode()) * 31) + this.f288719c.hashCode()) * 31) + this.f288720d.hashCode()) * 31;
        long r101 = this.f288721e;
        return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f288722f.hashCode()) * 31) + this.f288723g.hashCode();
    }

    public final String toString() {
        return "GetMatchVoiceRequest(botName=" + this.f288717a + ", botDesc=" + this.f288718b + ", voiceId=" + this.f288719c + ", botId=" + this.f288720d + ", botModelType=" + this.f288721e + ", languageCode=" + this.f288722f + ", scene=" + this.f288723g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f288717a);
        r100.writeString(this.f288718b);
        r100.writeString(this.f288719c);
        r100.writeString(this.f288720d);
        r100.writeLong(this.f288721e);
        r100.writeString(this.f288722f);
        r100.writeString(this.f288723g.name());
    }

    public GetMatchVoiceRequest(String r100, String r101, String r102, String r103, long r104, String r105, RecommendScene r106) {
        Intrinsics.checkNotNullParameter(r100, "botName");
        Intrinsics.checkNotNullParameter(r101, "botDesc");
        Intrinsics.checkNotNullParameter(r102, "voiceId");
        Intrinsics.checkNotNullParameter(r103, "botId");
        Intrinsics.checkNotNullParameter(r105, UserInfo.LANGUAGECODE);
        Intrinsics.checkNotNullParameter(r106, "scene");
        this.f288717a = r100;
        this.f288718b = r101;
        this.f288719c = r102;
        this.f288720d = r103;
        this.f288721e = r104;
        this.f288722f = r105;
        this.f288723g = r106;
    }

    public /* synthetic */ GetMatchVoiceRequest(String r100, String r110, String r111, String r112, long r113, String r114, RecommendScene r115, int r116) {
        String r101 = "";
        if ((r116 & 1) == 0) goto L5;
        String r102 = "";
    L7:
        if ((r116 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r116 & 4) == 0) goto L13;
        String r104 = "";
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r116 & 16) == 0) goto L21;
        long r106 = 0;
    L23:
        if ((r116 & 32) != 0) goto L27;
        r101 = r114;
    L27:
        if ((r116 & 64) == 0) goto L29;
        RecommendScene r107 = RecommendScene.NULL;
    L30:
        this(r102, r103, r104, r105, r106, r101, r107);
        return;
    L29:
        r107 = r115;
        goto L30
    L21:
        r106 = r113;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}
