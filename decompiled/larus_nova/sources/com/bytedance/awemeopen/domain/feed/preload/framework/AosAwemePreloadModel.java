package com.bytedance.awemeopen.domain.feed.preload.framework;

import com.byted.cast.common.TeaEventTrack;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import v34.b;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001Bw\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\u0016\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0016\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b9\u0010:J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÂ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÂ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÂ\u0003J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0000H\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0016HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0016HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003J{\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00162\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010%\u001a\u00020\u00162\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002HÆ\u0001R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010)R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010)R\u0019\u0010!\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b!\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010)\u001a\u0004\b,\u0010+R\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010-R\u0017\u0010#\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b#\u0010.\u001a\u0004\b/\u00100R\u0019\u0010$\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b$\u0010)\u001a\u0004\b1\u0010+R\u0017\u0010%\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b%\u0010.\u001a\u0004\b2\u00100R\u0019\u0010&\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b&\u0010)\u001a\u0004\b3\u0010+R\u0019\u0010'\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b'\u0010)\u001a\u0004\b4\u0010+R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/bytedance/awemeopen/domain/feed/preload/framework/AosAwemePreloadModel;", "Lv34/b;", "", "component1", "component2", "", "component5", "id", "aid", "gid", "getPriority", "priority", "", "setPriority", "getNext", TeaEventTrack.ACTION_DRAMA_NEXT, "setNext", "retryTimes", "setRetryTimes", "getRetryTimes", "", "other", "", "equals", "hashCode", "toString", "component3", "component4", "component6", "component7", "component8", "component9", "component10", "clientParams", "localParams", "needCachePicture", "contentScene", "preloadVideoData", "requestId", "hostEnterFrom", "copy", "Ljava/lang/String;", "getClientParams", "()Ljava/lang/String;", "getLocalParams", "I", "Z", "getNeedCachePicture", "()Z", "getContentScene", "getPreloadVideoData", "getRequestId", "getHostEnterFrom", "Lcom/bytedance/awemeopen/domain/feed/preload/framework/AosAwemePreloadModel;", "Ljava/util/concurrent/atomic/AtomicInteger;", "failedRetryTimes", "Ljava/util/concurrent/atomic/AtomicInteger;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class AosAwemePreloadModel implements b<AosAwemePreloadModel> {
    private final String aid;
    private final String clientParams;
    private final String contentScene;
    private AtomicInteger failedRetryTimes;
    private final String gid;
    private final String hostEnterFrom;
    private final String localParams;
    private final boolean needCachePicture;
    private AosAwemePreloadModel next;
    private final boolean preloadVideoData;
    private int priority;
    private final String requestId;

    private final String component1() {
        return this.aid;
    }

    private final String component2() {
        return this.gid;
    }

    private final int component5() {
        return this.priority;
    }

    public static /* synthetic */ AosAwemePreloadModel copy$default(AosAwemePreloadModel r110, String r111, String r112, String r113, String r114, int r115, boolean r116, String r117, boolean r118, String r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.aid;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.gid;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.clientParams;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.localParams;
    L19:
        if ((r212 & 16) == 0) goto L21;
        int r104 = r110.priority;
    L23:
        if ((r212 & 32) == 0) goto L25;
        boolean r105 = r110.needCachePicture;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.contentScene;
    L31:
        if ((r212 & 128) == 0) goto L33;
        boolean r107 = r110.preloadVideoData;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r119 = r110.requestId;
    L39:
        if ((r212 & 512) == 0) goto L41;
        String r108 = r110.hostEnterFrom;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
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

    public final String component10() {
        return this.hostEnterFrom;
    }

    public final String component3() {
        return this.clientParams;
    }

    public final String component4() {
        return this.localParams;
    }

    public final boolean component6() {
        return this.needCachePicture;
    }

    public final String component7() {
        return this.contentScene;
    }

    public final boolean component8() {
        return this.preloadVideoData;
    }

    public final String component9() {
        return this.requestId;
    }

    public final AosAwemePreloadModel copy(String r110, String r111, String r112, String r113, int r114, boolean r115, String r116, boolean r210, String r211, String r212) {
        return new AosAwemePreloadModel(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    @Override // v34.b
    public int getRetryTimes() {
        return this.failedRetryTimes.get();
    }

    public int hashCode() {
        return Objects.hashCode(this.aid);
    }

    @Override // v34.b
    public String id() {
        String r100 = this.aid;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L13;
        return gid();
    L13:
        return this.aid;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public String toString() {
        return "aid : " + this.aid + " priority : " + this.priority;
    }

    @Override // v34.b
    public /* bridge */ /* synthetic */ AosAwemePreloadModel getNext() {
        return getNext();
    }

    public String aid() {
        return this.aid;
    }

    public final String getClientParams() {
        return this.clientParams;
    }

    public final String getContentScene() {
        return this.contentScene;
    }

    public final String getHostEnterFrom() {
        return this.hostEnterFrom;
    }

    public final String getLocalParams() {
        return this.localParams;
    }

    public final boolean getNeedCachePicture() {
        return this.needCachePicture;
    }

    public final boolean getPreloadVideoData() {
        return this.preloadVideoData;
    }

    @Override // v34.b
    public int getPriority() {
        return this.priority;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public String gid() {
        return this.gid;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // v34.b
    public AosAwemePreloadModel getNext() {
        return this.next;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if ((r100 instanceof AosAwemePreloadModel) == true) goto L11;
    L13:
        return false;
    L11:
        if (Intrinsics.areEqual(this.aid, ((AosAwemePreloadModel) r100).aid) == false) goto L13;
        return true;
    }

    @Override // v34.b
    public /* bridge */ /* synthetic */ void setNext(AosAwemePreloadModel r100) {
        setNext2(r100);
    }

    public void setPriority(int r100) {
        this.priority = r100;
    }

    public void setRetryTimes(int r100) {
        this.failedRetryTimes.set(r100);
    }

    /* JADX INFO: renamed from: setNext, reason: avoid collision after fix types in other method */
    public void setNext2(AosAwemePreloadModel r100) {
        this.next = r100;
    }

    public AosAwemePreloadModel(String r100, String r101, String r102, String r103, int r104, boolean r105, String r106, boolean r107, String r108, String r110) {
        this.aid = r100;
        this.gid = r101;
        this.clientParams = r102;
        this.localParams = r103;
        this.priority = r104;
        this.needCachePicture = r105;
        this.contentScene = r106;
        this.preloadVideoData = r107;
        this.requestId = r108;
        this.hostEnterFrom = r110;
        this.failedRetryTimes = new AtomicInteger(0);
    }

    public /* synthetic */ AosAwemePreloadModel(String r110, String r111, String r112, String r113, int r114, boolean r115, String r116, boolean r117, String r118, String r210, int r211, DefaultConstructorMarker r212) {
        String r100 = null;
        if ((r211 & 2) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r211 & 4) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r211 & 8) == 0) goto L13;
        String r103 = null;
    L14:
        boolean r104 = false;
        if ((r211 & 16) == 0) goto L17;
        int r105 = 0;
    L19:
        if ((r211 & 32) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r211 & 64) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r211 & 128) != 0) goto L31;
        r104 = r117;
    L31:
        if ((r211 & 256) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r211 & 512) != 0) goto L38;
        r100 = r210;
    L38:
        this(r110, r101, r102, r103, r105, r106, r107, r104, r108, r100);
        return;
    L33:
        r108 = r118;
        goto L35
    L25:
        r107 = r116;
        goto L27
    L21:
        r106 = r115;
        goto L23
    L17:
        r105 = r114;
        goto L19
    L13:
        r103 = r113;
        goto L14
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }
}
