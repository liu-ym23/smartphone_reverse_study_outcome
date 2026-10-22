package kr8;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/music/mob/ClickMusicCardActionSheet;", "Lcom/larus/bmhome/music/mob/MobEvent;", "mobKey", "", "currentPage", "videoId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMobKey", "()Ljava/lang/String;", "getCurrentPage", "getVideoId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient String f505853a;

    @SerializedName("current_page")
    private final String currentPage;

    @SerializedName("video_id")
    private final String videoId;

    public c() {
        this(null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f505853a, r101.f505853a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.currentPage, r101.currentPage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.videoId, r101.videoId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f505853a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.currentPage;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.videoId;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ClickMusicCardActionSheet(mobKey=" + this.f505853a + ", currentPage=" + this.currentPage + ", videoId=" + this.videoId + ')';
    }

    @Override // kr8.l
    public final String a() {
        return this.f505853a;
    }

    @Override // kr8.l
    public final void b(by7.e r100, JSONObject r101) {
        l.a.a(this, r100, r101);
    }

    public c(String r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        String r103 = "click_music_card_action_sheet";
    L7:
        if ((r102 & 2) == 0) goto L10;
        r100 = "";
    L10:
        if ((r102 & 4) == 0) goto L12;
        r101 = "";
    L12:
        this.f505853a = r103;
        this.currentPage = r100;
        this.videoId = r101;
        return;
    L5:
        r103 = null;
        goto L7
    }
}
