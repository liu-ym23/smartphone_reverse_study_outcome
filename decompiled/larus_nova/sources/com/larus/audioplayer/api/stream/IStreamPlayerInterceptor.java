package com.larus.audioplayer.api.stream;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
public interface IStreamPlayerInterceptor {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/audioplayer/api/stream/IStreamPlayerInterceptor$StreamType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum StreamType extends Enum<StreamType> {
        public static final StreamType DOC = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StreamType[] f290194a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f290195b = null;
        private final String type;

        public static EnumEntries<StreamType> getEntries() {
            return f290195b;
        }

        static {
            StreamType r100 = new StreamType();
            DOC = r100;
            StreamType[] r101 = {r100};
            f290194a = r101;
            f290195b = EnumEntriesKt.enumEntries(r101);
        }

        public StreamType() {
            super(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 0);
            this.type = "AIDoc";
        }

        public static StreamType[] values() {
            return (StreamType[]) f290194a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public static StreamType valueOf(String r100) {
            return (StreamType) a.a(StreamType.class, r100);
        }
    }

    boolean a(JSONObject r100);

    void b();

    StreamType c();
}
