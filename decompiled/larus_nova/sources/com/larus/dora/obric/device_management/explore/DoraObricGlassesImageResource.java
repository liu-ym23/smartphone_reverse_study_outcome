package com.larus.dora.obric.device_management.explore;

import android.net.Uri;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class DoraObricGlassesImageResource {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesImageResource$Apk;", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesImageResource;", "resId", "", "<init>", "(I)V", "getResId", "()I", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Apk extends DoraObricGlassesImageResource {

        @SerializedName("resId")
        private final int resId;

        public final int getResId() {
            return this.resId;
        }

        public Apk(int r100) {
            super(null);
            this.resId = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesImageResource$FileUri;", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesImageResource;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FileUri extends DoraObricGlassesImageResource {

        @SerializedName("uri")
        private final Uri uri;

        public final Uri getUri() {
            return this.uri;
        }

        public FileUri(Uri r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            super(null);
            this.uri = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesImageResource$RemoteUrl;", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesImageResource;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RemoteUrl extends DoraObricGlassesImageResource {

        @SerializedName("url")
        private final String url;

        public final String getUrl() {
            return this.url;
        }

        public RemoteUrl(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            super(null);
            this.url = r100;
        }
    }

    private DoraObricGlassesImageResource() {
    }

    public /* synthetic */ DoraObricGlassesImageResource(DefaultConstructorMarker r100) {
        this();
    }
}
