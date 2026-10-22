package com.ss.android.lark.forwardv3.doubao;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.plugins.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0003\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0003\u0010\fJ\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016J\u0006\u0010+\u001a\u00020\u0006J\u0018\u0010,\u001a\u00020-2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020#H\u0016J\b\u0010/\u001a\u00020#H\u0016R\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001e\u0010$\u001a\u00020#2\u0006\u0010\r\u001a\u00020#@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00061"}, d2 = {"Lcom/ss/android/lark/forwardv3/doubao/DoubaoForwardContentAdapter;", "Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;", "Lcom/ss/android/lark/forwardv3/plugins/IForwardContentPluginProvider;", "<init>", "()V", "content", "Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardDoubaoContent;", "sessionId", "", "(Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardDoubaoContent;J)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "value", "getSessionId", "()J", "textContent", "", "getTextContent", "()Ljava/lang/String;", "setTextContent", "(Ljava/lang/String;)V", "previewText", "getPreviewText", "setPreviewText", "doubaoMsgIds", "", "getDoubaoMsgIds", "()Ljava/util/List;", "setDoubaoMsgIds", "(Ljava/util/List;)V", "", "hasDoubaoData", "getHasDoubaoData", "()Z", "", "doubaoDataSize", "getDoubaoDataSize", "()I", "createForwardPlugin", "Lcom/ss/android/lark/forwardv3/plugins/IForwardPlugin;", "rootFragment", "Landroidx/fragment/app/Fragment;", "toForwardDoubaoContent", "writeToParcel", "", "flags", "describeContents", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoForwardContentAdapter implements IForwardContent, h {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f425334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f425335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f425336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Long> f425337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f425338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f425339f;

    public static final class a implements Parcelable.Creator<DoubaoForwardContentAdapter> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoubaoForwardContentAdapter createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new DoubaoForwardContentAdapter(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final DoubaoForwardContentAdapter[] newArray(int r100) {
            return new DoubaoForwardContentAdapter[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public DoubaoForwardContentAdapter() {
        this.f425335b = "";
        this.f425336c = "";
        this.f425337d = CollectionsKt.emptyList();
    }

    public DoubaoForwardContentAdapter(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        this.f425334a = r100.readLong();
        String r101 = r100.readString();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.f425335b = r101;
        long[] r103 = r100.createLongArray();
        if (r103 == null) goto L9;
        List<Long> r104 = ArraysKt.toList(r103);
        if (r104 == null) goto L9;
    L10:
        this.f425337d = r104;
        boolean r105 = true;
        if (r100.readInt() == 1) goto L14;
        r105 = false;
    L14:
        this.f425338e = r105;
        this.f425339f = r100.readInt();
        String r106 = r100.readString();
        if (r106 == null) goto L18;
        r102 = r106;
    L18:
        this.f425336c = r102;
        return;
    L9:
        r104 = CollectionsKt.emptyList();
        goto L10
    }

    @Override // com.ss.android.lark.forwardv3.plugins.h
    public final b a(final Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "rootFragment");
        if (this.f425334a != 0) goto L7;
        return null;
    L7:
        return new b(this.f425334a, new DoubaoForwardContentAdapter$createForwardPlugin$1(r100));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeLong(this.f425334a);
        r100.writeString(this.f425335b);
        r100.writeLongArray(CollectionsKt.toLongArray(this.f425337d));
        r100.writeInt(this.f425338e ? 1 : 0);
        r100.writeInt(this.f425339f);
        r100.writeString(this.f425336c);
    }
}
