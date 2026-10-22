package com.larus.live.impl.bridge.download;

import com.bytedance.ies.xbridge.XReadableMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
public final class XDownloadFileMethodParamModel extends com.bytedance.ies.xbridge.model.params.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f355751g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f355752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f355753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public XReadableMap f355754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public XReadableMap f355755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SaveWay f355756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f355757f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/live/impl/bridge/download/XDownloadFileMethodParamModel$SaveWay;", "", "<init>", "(Ljava/lang/String;I)V", "video", "image", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SaveWay extends Enum<SaveWay> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SaveWay[] f355758a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f355759b = null;
        public static final SaveWay image = null;
        public static final SaveWay video = null;

        public static EnumEntries<SaveWay> getEntries() {
            return f355759b;
        }

        static {
            SaveWay r100 = new SaveWay("video", 0);
            video = r100;
            SaveWay r101 = new SaveWay("image", 1);
            image = r101;
            SaveWay[] r102 = {r100, r101};
            f355758a = r102;
            f355759b = EnumEntriesKt.enumEntries(r102);
        }

        public static SaveWay[] values() {
            return (SaveWay[]) f355758a.clone();
        }

        public static SaveWay valueOf(String r100) {
            return (SaveWay) r27.a.a(SaveWay.class, r100);
        }

        public SaveWay(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.model.params.a
    public final List<String> provideParamList() {
        return CollectionsKt.listOf(new String[]{"url", "extension", "params", "header", "saveToAlbum"});
    }

    public XDownloadFileMethodParamModel() {
        this.f355757f = true;
    }
}
