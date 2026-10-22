package com.lark.wire;

import android.os.Parcel;
import android.os.Parcelable;
import com.lark.wire.Message;
import com.lark.wire.Message.a;
import java.lang.reflect.Array;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000 \u0014*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00022\u00020\u0005:\u0002\u0013\u0014B\u001f\b\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016¨\u0006\u0015"}, d2 = {"Lcom/lark/wire/AndroidMessage;", "M", "Lcom/lark/wire/Message;", "B", "Lcom/lark/wire/Message$Builder;", "Landroid/os/Parcelable;", "adapter", "Lcom/lark/wire/ProtoAdapter;", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/wire/ProtoAdapter;Lokio/ByteString;)V", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "", "describeContents", "ProtoAdapterCreator", "Companion", "wire-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AndroidMessage<M extends Message<M, B>, B extends Message.a<M, B>> extends Message<M, B> implements Parcelable {
    public static final a Companion = null;

    public static final class a {
        public a() {
        }
    }

    public static final class b<M> implements Parcelable.Creator<M> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ProtoAdapter<M> f282708a;

        public b(ProtoAdapter<M> r100) {
            Intrinsics.checkNotNullParameter(r100, "adapter");
            this.f282708a = r100;
        }

        @Override // android.os.Parcelable.Creator
        public final M createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "input");
            return this.f282708a.e(r100.createByteArray());
        }

        @Override // android.os.Parcelable.Creator
        public final M[] newArray(int r100) {
            KClass<?> r101 = this.f282708a.getType();
            if (r101 == null) goto L5;
            Class r102 = JvmClassMappingKt.getJavaObjectType(r101);
        L6:
            Object r103 = Array.newInstance(r102, r100);
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Array<M of com.lark.wire.AndroidMessage.ProtoAdapterCreator>");
            return (M[]) ((Object[]) r103);
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @JvmStatic
    public static final <E> Parcelable.Creator<E> newCreator(ProtoAdapter<E> r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "adapter");
        return new b(r100);
    }

    public AndroidMessage(ProtoAdapter<M> r100, ByteString r101) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Intrinsics.checkNotNullParameter(r101, "unknownFields");
        super(r100, r101);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeByteArray(encode());
    }
}
