package com.ss.android.ugc.aweme.discover.commodity.utils;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/utils/MapWriterInner;", "Lcom/google/gson/stream/JsonWriter;", "<init>", "()V", "Companion", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public abstract class MapWriterInner extends JsonWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MapWriterInner$Companion$UNWRITABLE_WRITER$1 f450379a = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/utils/MapWriterInner$Companion;", "", "()V", "UNWRITABLE_WRITER", "Ljava/io/Writer;", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.ugc.aweme.discover.commodity.utils.MapWriterInner$Companion$UNWRITABLE_WRITER$1] */
    static {
        new Companion(0);
        f450379a = new MapWriterInner$Companion$UNWRITABLE_WRITER$1();
    }

    public MapWriterInner() {
        super(f450379a);
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter value(Boolean r100) throws IOException {
        MapWriter r101 = (MapWriter) this;
        if (r100 != null) goto L5;
        r101.b(null);
    L6:
        return r101;
    L5:
        r101.b(r100);
        goto L6
    }
}
