package com.ss.android.lark.image.uploader.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.image.entity.LoadParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R.\u0010\b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tj\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR.\u0010\u000e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tj\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/image/uploader/config/FileTypeConfig;", "", "<init>", "()V", "enable", "", "getEnable", "()Z", "localWhiteList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLocalWhiteList", "()Ljava/util/ArrayList;", "serverWhiteList", "getServerWhiteList", "Companion", "image-uploader_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f426373a = null;

    @SerializedName("enable_file_type_check")
    private final boolean enable;

    @SerializedName("local_valid_image_white_list")
    private final ArrayList<String> localWhiteList;

    @SerializedName("server_transcode_white_list")
    private final ArrayList<String> serverWhiteList;

    public static final class a {
    }

    static {
        f426373a = CollectionsKt.listOf(new String[]{LoadParams.ImageFormat.PNG, "webp", "jpg", LoadParams.ImageFormat.JPEG, "heic", "heif", "bmp", "x-icon", "vnd.microsoft.icon", "gif"});
    }

    public d() {
        this.enable = true;
        List<String> r100 = f426373a;
        this.localWhiteList = new ArrayList(r100);
        this.serverWhiteList = new ArrayList(r100);
    }

    public final boolean a() {
        return this.enable;
    }

    public final ArrayList<String> b() {
        return this.localWhiteList;
    }

    public final ArrayList<String> c() {
        return this.serverWhiteList;
    }
}
