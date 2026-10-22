package com.squareup.wire;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.lang.reflect.Array;
import okio.ByteString;

/* JADX INFO: loaded from: classes34.dex */
public abstract class AndroidMessage<M extends Message<M, B>, B extends Message.Builder<M, B>> extends Message<M, B> implements Parcelable {

    public static final class ProtoAdapterCreator<M> implements Parcelable.Creator<M> {
        private final ProtoAdapter<M> adapter;

        public ProtoAdapterCreator(ProtoAdapter<M> r100) {
            this.adapter = r100;
        }

        @Override // android.os.Parcelable.Creator
        public M createFromParcel(Parcel r100) {
            return this.adapter.decode(r100.createByteArray());
        L4:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // android.os.Parcelable.Creator
        public M[] newArray(int r100) {
            return (M[]) ((Object[]) Array.newInstance(this.adapter.javaType, r100));
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public static <E> Parcelable.Creator<E> newCreator(ProtoAdapter<E> r100) {
        return new ProtoAdapterCreator(r100);
    }

    public AndroidMessage(ProtoAdapter<M> r100, ByteString r101) {
        super(r100, r101);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeByteArray(encode());
    }
}
