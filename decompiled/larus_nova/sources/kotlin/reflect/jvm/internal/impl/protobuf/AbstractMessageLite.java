package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractMessageLite implements MessageLite {
    protected int memoizedHashCode;

    public static abstract class Builder<BuilderType extends Builder> implements MessageLite.Builder {

        public static final class LimitedInputStream extends FilterInputStream {
            private int limit;

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.limit > 0) goto L6;
                return -1;
            L6:
                int r100 = super.read();
                if (r100 < 0) goto L9;
                this.limit--;
            L9:
                return r100;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.limit);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long r100) throws IOException {
                long r101 = super.skip(Math.min(r100, this.limit));
                if (r101 < 0) goto L5;
                this.limit = (int) (((long) this.limit) - r101);
            L5:
                return r101;
            }

            public LimitedInputStream(InputStream r100, int r101) {
                super(r100);
                this.limit = r101;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] r100, int r101, int r102) throws IOException {
                int r103 = this.limit;
                if (r103 > 0) goto L6;
                return -1;
            L6:
                int r104 = super.read(r100, r101, Math.min(r102, r103));
                if (r104 < 0) goto L9;
                this.limit -= r104;
            L9:
                return r104;
            }
        }

        /* JADX INFO: renamed from: clone */
        public abstract BuilderType mo10730clone();

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public abstract BuilderType mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException;

        public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return mo10730clone();
        }

        public Builder() {
        }

        public static UninitializedMessageException newUninitializedMessageException(MessageLite r100) {
            return new UninitializedMessageException(r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return mergeFrom(r100, r101);
        }
    }

    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    public AbstractMessageLite() {
        this.memoizedHashCode = 0;
    }

    public void writeDelimitedTo(OutputStream r100) throws IOException {
        int r101 = getSerializedSize();
        CodedOutputStream r102 = CodedOutputStream.newInstance(r100, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(r101) + r101));
        r102.writeRawVarint32(r101);
        writeTo(r102);
        r102.flush();
    }
}
