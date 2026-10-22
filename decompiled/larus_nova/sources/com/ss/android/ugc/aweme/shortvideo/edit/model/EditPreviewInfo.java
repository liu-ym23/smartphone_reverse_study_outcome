package com.ss.android.ugc.aweme.shortvideo.edit.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.ugc.aweme.creative.CreativePath;
import com.ss.android.ugc.aweme.creative.CreativeSuppressCheck;
import com.ss.android.ugc.aweme.draft.DraftTransMark;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u0011\n\u0002\b\u0012\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0001QB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005BC\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0014\u0010G\u001a\u00020\u00002\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\b\u0010I\u001a\u00020\nH\u0016J\b\u0010J\u001a\u0004\u0018\u00010\u0010J;\u0010K\u001a\u00020L2\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010-2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010-2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010-¢\u0006\u0002\u0010MJ\u0018\u0010N\u001a\u00020L2\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\nH\u0016R\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001e\u0010 \u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010\u000f\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016R\u001a\u0010'\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R(\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00103\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00107\"\u0004\b;\u00109R(\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b=\u0010/\"\u0004\b>\u00101R\u0011\u0010?\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0011\u0010C\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bD\u0010BR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010F¨\u0006R"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/edit/model/EditPreviewInfo;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "videoList", "", "Lcom/ss/android/ugc/aweme/shortvideo/edit/model/EditVideoSegment;", "previewWidth", "", "previewHeight", "sceneIn", "", "sceneOut", "initDraftDir", "", "(Ljava/util/List;IIJJLjava/lang/String;)V", "calculateHeight", "getCalculateHeight", "()I", "setCalculateHeight", "(I)V", "calculateSourceHeight", "getCalculateSourceHeight", "setCalculateSourceHeight", "calculateSourceWidth", "getCalculateSourceWidth", "setCalculateSourceWidth", "calculateWidth", "getCalculateWidth", "setCalculateWidth", "draftDir", "getDraftDir", "()Ljava/lang/String;", "setDraftDir", "(Ljava/lang/String;)V", "getPreviewHeight", "setPreviewHeight", "previewVideoLength", "getPreviewVideoLength", "setPreviewVideoLength", "getPreviewWidth", "setPreviewWidth", "reverseAudioArray", "", "getReverseAudioArray", "()[Ljava/lang/String;", "setReverseAudioArray", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "reverseVideoArray", "getReverseVideoArray", "setReverseVideoArray", "getSceneIn", "()J", "setSceneIn", "(J)V", "getSceneOut", "setSceneOut", "tempVideoArray", "getTempVideoArray", "setTempVideoArray", "totalVideoHeight", "", "getTotalVideoHeight", "()[I", "totalVideoWidth", "getTotalVideoWidth", "getVideoList", "()Ljava/util/List;", "cloneWithNewVideos", "newVideoList", "describeContents", "reverseVideo", "updateReverseVideoContent", "", "([Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V", "writeToParcel", "dest", "flags", "Companion", "lib-api_release"}, k = 1, mv = {1, 4, 1})
@CreativeSuppressCheck
public final class EditPreviewInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<EditPreviewInfo> CREATOR = null;
    public static final Companion Companion = null;
    private int calculateHeight;
    private int calculateSourceHeight;
    private int calculateSourceWidth;
    private int calculateWidth;

    @DraftTransMark
    private String draftDir;

    @DraftTransMark
    private final String initDraftDir;
    private int previewHeight;
    private int previewVideoLength;
    private int previewWidth;

    @CreativePath
    @DraftTransMark
    private String[] reverseAudioArray;

    @CreativePath(blockCreative = true)
    @DraftTransMark
    private String[] reverseVideoArray;
    private long sceneIn;
    private long sceneOut;

    @CreativePath
    @DraftTransMark
    private String[] tempVideoArray;

    @DraftTransMark
    private final List<EditVideoSegment> videoList;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/edit/model/EditPreviewInfo$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/aweme/shortvideo/edit/model/EditPreviewInfo;", "lib-api_release"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        Companion = new Companion(0);
        CREATOR = new EditPreviewInfo$Companion$CREATOR$1();
    }

    public final int[] getTotalVideoHeight() {
        List<EditVideoSegment> r100 = this.videoList;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.add(Integer.valueOf(((EditVideoSegment) r102.next()).getVideoFileInfo().getHeight()));
        goto L4
    L7:
        return CollectionsKt.toIntArray(r101);
    }

    public final int[] getTotalVideoWidth() {
        List<EditVideoSegment> r100 = this.videoList;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.add(Integer.valueOf(((EditVideoSegment) r102.next()).getVideoFileInfo().getWidth()));
        goto L4
    L7:
        return CollectionsKt.toIntArray(r101);
    }

    public final String reverseVideo() {
        String[] r100 = this.reverseVideoArray;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100[0];
    }

    public final int getCalculateHeight() {
        return this.calculateHeight;
    }

    public final int getCalculateSourceHeight() {
        return this.calculateSourceHeight;
    }

    public final int getCalculateSourceWidth() {
        return this.calculateSourceWidth;
    }

    public final int getCalculateWidth() {
        return this.calculateWidth;
    }

    public final String getDraftDir() {
        return this.draftDir;
    }

    public final int getPreviewHeight() {
        return this.previewHeight;
    }

    public final int getPreviewVideoLength() {
        return this.previewVideoLength;
    }

    public final int getPreviewWidth() {
        return this.previewWidth;
    }

    public final String[] getReverseAudioArray() {
        return this.reverseAudioArray;
    }

    public final String[] getReverseVideoArray() {
        return this.reverseVideoArray;
    }

    public final long getSceneIn() {
        return this.sceneIn;
    }

    public final long getSceneOut() {
        return this.sceneOut;
    }

    public final String[] getTempVideoArray() {
        return this.tempVideoArray;
    }

    public final List<EditVideoSegment> getVideoList() {
        return this.videoList;
    }

    public EditPreviewInfo(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "source");
        ArrayList r100 = r110.createTypedArrayList(EditVideoSegment.CREATOR);
        if (r100 != null) goto L6;
        r100 = new ArrayList();
    L6:
        this(r100, r110.readInt(), r110.readInt(), r110.readLong(), r110.readLong(), "");
        String r101 = r110.readString();
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        this.draftDir = r101;
        this.calculateWidth = r110.readInt();
        this.calculateHeight = r110.readInt();
        this.previewVideoLength = r110.readInt();
        this.reverseVideoArray = r110.createStringArray();
        this.reverseAudioArray = r110.createStringArray();
        this.tempVideoArray = r110.createStringArray();
    }

    public final EditPreviewInfo cloneWithNewVideos(List<EditVideoSegment> r110) {
        Intrinsics.checkNotNullParameter(r110, "newVideoList");
        EditPreviewInfo r100 = new EditPreviewInfo(r110, this.previewWidth, this.previewHeight, this.sceneIn, this.sceneOut, this.draftDir);
        r100.calculateWidth = this.calculateWidth;
        r100.calculateHeight = this.calculateHeight;
        r100.previewVideoLength = this.previewVideoLength;
        r100.reverseVideoArray = this.reverseVideoArray;
        r100.reverseAudioArray = this.reverseAudioArray;
        r100.tempVideoArray = this.tempVideoArray;
        return r100;
    }

    public final void setCalculateHeight(int r100) {
        this.calculateHeight = r100;
    }

    public final void setCalculateSourceHeight(int r100) {
        this.calculateSourceHeight = r100;
    }

    public final void setCalculateSourceWidth(int r100) {
        this.calculateSourceWidth = r100;
    }

    public final void setCalculateWidth(int r100) {
        this.calculateWidth = r100;
    }

    public final void setDraftDir(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.draftDir = r100;
    }

    public final void setPreviewHeight(int r100) {
        this.previewHeight = r100;
    }

    public final void setPreviewVideoLength(int r100) {
        this.previewVideoLength = r100;
    }

    public final void setPreviewWidth(int r100) {
        this.previewWidth = r100;
    }

    public final void setReverseAudioArray(String[] r100) {
        this.reverseAudioArray = r100;
    }

    public final void setReverseVideoArray(String[] r100) {
        this.reverseVideoArray = r100;
    }

    public final void setSceneIn(long r100) {
        this.sceneIn = r100;
    }

    public final void setSceneOut(long r100) {
        this.sceneOut = r100;
    }

    public final void setTempVideoArray(String[] r100) {
        this.tempVideoArray = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeTypedList(this.videoList);
        r100.writeInt(this.previewWidth);
        r100.writeInt(this.previewHeight);
        r100.writeLong(this.sceneIn);
        r100.writeLong(this.sceneOut);
        r100.writeString(this.draftDir);
        r100.writeInt(this.calculateWidth);
        r100.writeInt(this.calculateHeight);
        r100.writeInt(this.previewVideoLength);
        r100.writeStringArray(this.reverseVideoArray);
        r100.writeStringArray(this.reverseAudioArray);
        r100.writeStringArray(this.tempVideoArray);
    }

    public final void updateReverseVideoContent(String[] r100, String[] r101, String[] r102) {
        this.reverseVideoArray = r100;
        this.reverseAudioArray = r101;
        this.tempVideoArray = r102;
    }

    public EditPreviewInfo(List<EditVideoSegment> r100, int r101, int r102, long r103, long r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "videoList");
        Intrinsics.checkNotNullParameter(r105, "initDraftDir");
        this.videoList = r100;
        this.previewWidth = r101;
        this.previewHeight = r102;
        this.sceneIn = r103;
        this.sceneOut = r104;
        this.initDraftDir = r105;
        this.draftDir = r105;
    }

    public /* synthetic */ EditPreviewInfo(List r110, int r111, int r112, long r113, long r114, String r115, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 2) == 0) goto L5;
        int r100 = -1;
    L7:
        if ((r210 & 4) == 0) goto L9;
        int r101 = -1;
    L11:
        if ((r210 & 8) == 0) goto L13;
        long r102 = -1;
    L15:
        if ((r210 & 16) == 0) goto L17;
        long r103 = -1;
    L18:
        this(r110, r100, r101, r102, r103, r115);
        return;
    L17:
        r103 = r114;
        goto L18
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
