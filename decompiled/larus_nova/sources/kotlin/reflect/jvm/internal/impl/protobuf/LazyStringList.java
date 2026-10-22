package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface LazyStringList extends ProtocolStringList {
    void add(ByteString r100);

    ByteString getByteString(int r100);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();
}
