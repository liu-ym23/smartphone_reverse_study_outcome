package com.larus.photopicker.v2.impl.model;

import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0013"}, d2 = {"Lcom/larus/photopicker/v2/impl/model/MediaTab;", "", "title", "", "mobName", "id", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "getTitle", "()Ljava/lang/String;", "getMobName", "getId", "()I", AccountType.ALL, "VIDEO", "IMAGE", "toMediaType", "Lcom/larus/photopicker/v2/impl/data/model/MediaType;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MediaTab extends Enum<MediaTab> {
    public static final MediaTab ALL = null;
    public static final MediaTab IMAGE = null;
    public static final MediaTab VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MediaTab[] f364542a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364543b = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f364544id;
    private final String mobName;
    private final String title;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f364545a = null;

        static {
            int[] r100 = new int[MediaTab.values().length];
            r100[MediaTab.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[MediaTab.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[MediaTab.IMAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f364545a = r100;
        }
    }

    public static EnumEntries<MediaTab> getEntries() {
        return f364543b;
    }

    static {
        AppHost.Companion r100 = AppHost.f326268a;
        MediaTab r101 = new MediaTab(AccountType.ALL, 0, r100.getApplication().getResources().getString(R.string.larus_videoSum_upload_tab_all), "all", 0);
        ALL = r101;
        MediaTab r102 = new MediaTab("VIDEO", 1, r100.getApplication().getResources().getString(R.string.larus_videoSum_upload_tab_video), "video", 1);
        VIDEO = r102;
        MediaTab r103 = new MediaTab("IMAGE", 2, r100.getApplication().getResources().getString(R.string.larus_videoSum_upload_tab_image), "pic", 2);
        IMAGE = r103;
        MediaTab[] r104 = {r101, r102, r103};
        f364542a = r104;
        f364543b = EnumEntriesKt.enumEntries(r104);
    }

    public static MediaTab[] values() {
        return (MediaTab[]) f364542a.clone();
    }

    public final MediaType toMediaType() {
        int r100 = a.f364545a[ordinal()];
        if (r100 != 1) goto L5;
        return null;
    L5:
        if (r100 == 2) goto L15;
        if (r100 != 3) goto L10;
        return MediaType.IMAGE;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return MediaType.VIDEO;
    }

    public final int getId() {
        return this.f364544id;
    }

    public final String getMobName() {
        return this.mobName;
    }

    public final String getTitle() {
        return this.title;
    }

    public static MediaTab valueOf(String r100) {
        return (MediaTab) r27.a.a(MediaTab.class, r100);
    }

    public MediaTab(String r100, int r101, String r102, String r103, int r104) {
        super(r100, r101);
        this.title = r102;
        this.mobName = r103;
        this.f364544id = r104;
    }
}
