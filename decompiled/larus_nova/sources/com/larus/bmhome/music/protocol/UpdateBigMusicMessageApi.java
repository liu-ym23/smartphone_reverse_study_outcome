package com.larus.bmhome.music.protocol;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.network.bean.BizResponse;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00072\u00020\u0001:\u0002\u0007\bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/music/protocol/UpdateBigMusicMessageApi;", "", "updateBigMusicMessage", "Lcom/larus/network/bean/BizResponse;", "request", "Lcom/larus/bmhome/music/protocol/UpdateBigMusicMessageApi$UpdateBigMusicRequest;", "(Lcom/larus/bmhome/music/protocol/UpdateBigMusicMessageApi$UpdateBigMusicRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "UpdateBigMusicRequest", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface UpdateBigMusicMessageApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f313050a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f313051a = null;

        static {
            f313051a = new a();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/music/protocol/UpdateBigMusicMessageApi$UpdateBigMusicRequest;", "", "messageId", "", "title", "coverUri", DBDefinition.TASK_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessageId", "()Ljava/lang/String;", "getTitle", "getCoverUri", "getTaskId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("cover_uri")
        private final String coverUri;

        @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
        private final String messageId;

        @SerializedName("task_id")
        private final String taskId;

        @SerializedName("title")
        private final String title;

        public b() {
            this(null, null, null, null, 15);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.coverUri, r101.coverUri) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            String r100 = this.messageId;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.title;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.coverUri;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.taskId;
            if (r110 == null) goto L19;
            r101 = r110.hashCode();
        L19:
            return r109 + r101;
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "UpdateBigMusicRequest(messageId=" + this.messageId + ", title=" + this.title + ", coverUri=" + this.coverUri + ", taskId=" + this.taskId + ')';
        }

        public b(String r100, String r101, String r102, String r103, int r104) {
            if ((r104 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = null;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = null;
        L14:
            this.messageId = r100;
            this.title = r101;
            this.coverUri = r102;
            this.taskId = r103;
        }
    }

    static {
        f313050a = a.f313051a;
    }

    @POST("/alice/media/bigmusic/update_message")
    Object updateBigMusicMessage(@Body b r100, Continuation<? super BizResponse<Object>> r101);
}
