package com.obric.livecard.api.entity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.heytap.mcssdk.constant.b;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.IslandCardCallback;
import com.obric.livecard.api.LiveCardType;
import com.obric.livecard.api.exception.IslandUnsupportedException;
import com.obric.livecard.api.island.IslandApi;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\bI\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u0000 z2\u00020\u0001:\u0001zB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007BË\u0001\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010!J\u000b\u0010O\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010R\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\t\u0010S\u001a\u00020\u0012HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010W\u001a\u00020\u0006HÂ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010^\u001a\u00020\u0012HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0015HÆ\u0003JÔ\u0001\u0010`\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00122\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010aJ\b\u0010b\u001a\u00020\u0006H\u0016J\u0013\u0010c\u001a\u00020\u00182\b\u0010d\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\u0013\u0010e\u001a\u0004\u0018\u00010\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010fJ\b\u0010g\u001a\u00020\u0006H\u0016J\u000e\u0010h\u001a\u00020i2\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010j\u001a\u00020iJ \u0010k\u001a\u00020i2\u0006\u0010l\u001a\u00020\t2\u0006\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010\u001dJ \u0010p\u001a\u00020i2\u0006\u0010l\u001a\u00020\t2\u0006\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010\u001aJ\"\u0010q\u001a\u00020i2\u0006\u0010l\u001a\u00020\t2\u0006\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010nH\u0002J\u000e\u0010r\u001a\u00020i2\u0006\u0010s\u001a\u00020\u0012J\b\u0010t\u001a\u00020nH\u0016J\u000e\u0010u\u001a\u00020i2\u0006\u0010l\u001a\u00020\tJ\u0019\u0010v\u001a\u00020i2\u0006\u0010l\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010wJ\u0006\u0010x\u001a\u00020iJ\u0018\u0010y\u001a\u00020i2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0006H\u0016R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010-\"\u0004\b/\u00100R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u001b\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0015\u0010 \u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010$\u001a\u0004\b>\u0010#R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010-\"\u0004\b@\u00100R\u001c\u0010\f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010-\"\u0004\bB\u00100R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010\u0013\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u00107\"\u0004\bL\u00109R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006{"}, d2 = {"Lcom/obric/livecard/api/entity/IslandSession;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "version", "", "(ILandroid/os/Parcel;)V", "collapseWidget", "Lcom/obric/livecard/api/entity/IslandWidget;", "expandWidget", "nodeWidget", "notificationWidget", "intent", "Landroid/app/PendingIntent;", "callback", "Lcom/obric/livecard/api/IslandCardCallback;", "autoDismissDuration", "", DBDefinition.TASK_ID, "type", "Lcom/obric/livecard/api/LiveCardType;", "currWidget", "canFrontShow", "", "ext", "Lcom/google/gson/JsonObject;", "flags", "sessionContext", "", "sceneEntity", "Lcom/obric/livecard/api/entity/ISceneEntity;", "islandAutoDismissDuration", "(Lcom/obric/livecard/api/entity/IslandWidget;Lcom/obric/livecard/api/entity/IslandWidget;Lcom/obric/livecard/api/entity/IslandWidget;Lcom/obric/livecard/api/entity/IslandWidget;Landroid/app/PendingIntent;Lcom/obric/livecard/api/IslandCardCallback;Ljava/lang/Long;JLcom/obric/livecard/api/LiveCardType;Lcom/obric/livecard/api/entity/IslandWidget;Ljava/lang/Boolean;Lcom/google/gson/JsonObject;JLjava/lang/Object;Lcom/obric/livecard/api/entity/ISceneEntity;Ljava/lang/Long;I)V", "getAutoDismissDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCallback", "()Lcom/obric/livecard/api/IslandCardCallback;", "getCanFrontShow", "()Ljava/lang/Boolean;", "setCanFrontShow", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCollapseWidget", "()Lcom/obric/livecard/api/entity/IslandWidget;", "getCurrWidget", "setCurrWidget", "(Lcom/obric/livecard/api/entity/IslandWidget;)V", "getExpandWidget", "getExt", "()Lcom/google/gson/JsonObject;", "setExt", "(Lcom/google/gson/JsonObject;)V", "getFlags", "()J", "setFlags", "(J)V", "getIntent", "()Landroid/app/PendingIntent;", "setIntent", "(Landroid/app/PendingIntent;)V", "getIslandAutoDismissDuration", "getNodeWidget", "setNodeWidget", "getNotificationWidget", "setNotificationWidget", "getSceneEntity", "()Lcom/obric/livecard/api/entity/ISceneEntity;", "setSceneEntity", "(Lcom/obric/livecard/api/entity/ISceneEntity;)V", "getSessionContext", "()Ljava/lang/Object;", "setSessionContext", "(Ljava/lang/Object;)V", "getTaskId", "setTaskId", "getType", "()Lcom/obric/livecard/api/LiveCardType;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/obric/livecard/api/entity/IslandWidget;Lcom/obric/livecard/api/entity/IslandWidget;Lcom/obric/livecard/api/entity/IslandWidget;Lcom/obric/livecard/api/entity/IslandWidget;Landroid/app/PendingIntent;Lcom/obric/livecard/api/IslandCardCallback;Ljava/lang/Long;JLcom/obric/livecard/api/LiveCardType;Lcom/obric/livecard/api/entity/IslandWidget;Ljava/lang/Boolean;Lcom/google/gson/JsonObject;JLjava/lang/Object;Lcom/obric/livecard/api/entity/ISceneEntity;Ljava/lang/Long;I)Lcom/obric/livecard/api/entity/IslandSession;", "describeContents", "equals", "other", "getPriority", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hashCode", "readFromParcel", "", "refreshScene", "sendAnyEvent", "targetWidget", b.f276361k, "", "data", "sendEvent", "sendEventInner", "setPriority", "priority", "toString", "update", "updateAnimation", "(Lcom/obric/livecard/api/entity/IslandWidget;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFlags", "writeToParcel", "CREATOR", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IslandSession implements Parcelable {
    public static final CREATOR CREATOR = null;
    public static final int MAGIC_CODE = 429261353;
    public static final int VERSION_CODE = 4;
    private final Long autoDismissDuration;
    private final IslandCardCallback callback;
    private Boolean canFrontShow;
    private final IslandWidget collapseWidget;
    private IslandWidget currWidget;
    private final IslandWidget expandWidget;
    private JsonObject ext;
    private long flags;
    private PendingIntent intent;
    private final Long islandAutoDismissDuration;
    private IslandWidget nodeWidget;
    private IslandWidget notificationWidget;
    private ISceneEntity sceneEntity;
    private Object sessionContext;
    private long taskId;
    private final LiveCardType type;
    private final int version;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/livecard/api/entity/IslandSession$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/livecard/api/entity/IslandSession;", "()V", "MAGIC_CODE", "", "VERSION_CODE", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/livecard/api/entity/IslandSession;", "parseSceneEntity", "Lcom/obric/livecard/api/entity/ISceneEntity;", "json", "", "readVersion", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<IslandSession> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        private final ISceneEntity parseSceneEntity(String r100) {
            return SceneEntityParser.INSTANCE.parse(r100);
        }

        private final int readVersion(Parcel r100) {
            int r101 = r100.dataPosition();
            int r102 = 0;
            r102 = 0;
        L8:
            r100.setDataPosition(r101);
        L9:
            return r102;
        L4:
            if (r100.readInt() != 429261353) goto L6;
            int r103 = r100.readInt();     // Catch: Exception -> L8
            r102 = r103;
            r100 = r103;
        L10:
            goto L9
        L6:
            r100.setDataPosition(r101);     // Catch: Exception -> L8
            r100 = r100;
            goto L10
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IslandSession createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new IslandSession(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IslandSession[] newArray(int r100) {
            return newArray(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IslandSession createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IslandSession[] newArray(int r100) {
            return new IslandSession[r100];
        }

        public static final /* synthetic */ ISceneEntity access$parseSceneEntity(CREATOR r100, String r101) {
            return r100.parseSceneEntity(r101);
        }

        public static final /* synthetic */ int access$readVersion(CREATOR r100, Parcel r101) {
            return r100.readVersion(r101);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public IslandSession() {
        this(null, null, null, null, null, null, null, 0, null, null, null, null, 0, null, null, null, 0, 131071, null);
    }

    private final int component17() {
        return this.version;
    }

    public static /* synthetic */ IslandSession copy$default(IslandSession r110, IslandWidget r111, IslandWidget r112, IslandWidget r210, IslandWidget r211, PendingIntent r212, IslandCardCallback r213, Long r214, long r215, LiveCardType r216, IslandWidget r217, Boolean r218, JsonObject r310, long r311, Object r312, ISceneEntity r313, Long r314, int r315, int r316, Object r317) {
        if ((r316 & 1) == 0) goto L5;
        IslandWidget r100 = r110.collapseWidget;
    L7:
        if ((r316 & 2) == 0) goto L9;
        IslandWidget r101 = r110.expandWidget;
    L11:
        if ((r316 & 4) == 0) goto L13;
        IslandWidget r102 = r110.nodeWidget;
    L15:
        if ((r316 & 8) == 0) goto L17;
        IslandWidget r103 = r110.notificationWidget;
    L19:
        if ((r316 & 16) == 0) goto L21;
        PendingIntent r104 = r110.intent;
    L23:
        if ((r316 & 32) == 0) goto L25;
        IslandCardCallback r105 = r110.callback;
    L27:
        if ((r316 & 64) == 0) goto L29;
        Long r106 = r110.autoDismissDuration;
    L31:
        if ((r316 & 128) == 0) goto L33;
        long r107 = r110.taskId;
    L35:
        if ((r316 & 256) == 0) goto L37;
        LiveCardType r113 = r110.type;
    L39:
        if ((r316 & 512) == 0) goto L41;
        IslandWidget r114 = r110.currWidget;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        Boolean r115 = r110.canFrontShow;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        JsonObject r116 = r110.ext;
    L50:
        JsonObject r318 = r116;
        if ((r316 & 4096) == 0) goto L53;
        long r117 = r110.flags;
    L54:
        long r319 = r117;
        if ((r316 & 8192) == 0) goto L57;
        Object r118 = r110.sessionContext;
    L59:
        if ((r316 & 16384) == 0) goto L61;
        ISceneEntity r119 = r110.sceneEntity;
    L62:
        ISceneEntity r320 = r119;
        if ((r316 & 32768) == 0) goto L65;
        Long r120 = r110.islandAutoDismissDuration;
    L67:
        if ((r316 & 65536) == 0) goto L69;
        int r108 = r110.version;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r318, r319, r118, r320, r120, r108);
    L69:
        r108 = r315;
        goto L71
    L65:
        r120 = r314;
        goto L67
    L61:
        r119 = r313;
        goto L62
    L57:
        r118 = r312;
        goto L59
    L53:
        r117 = r311;
        goto L54
    L49:
        r116 = r310;
        goto L50
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final IslandWidget component1() {
        return this.collapseWidget;
    }

    public final IslandWidget component10() {
        return this.currWidget;
    }

    public final Boolean component11() {
        return this.canFrontShow;
    }

    public final JsonObject component12() {
        return this.ext;
    }

    public final long component13() {
        return this.flags;
    }

    public final Object component14() {
        return this.sessionContext;
    }

    public final ISceneEntity component15() {
        return this.sceneEntity;
    }

    public final Long component16() {
        return this.islandAutoDismissDuration;
    }

    public final IslandWidget component2() {
        return this.expandWidget;
    }

    public final IslandWidget component3() {
        return this.nodeWidget;
    }

    public final IslandWidget component4() {
        return this.notificationWidget;
    }

    public final PendingIntent component5() {
        return this.intent;
    }

    public final IslandCardCallback component6() {
        return this.callback;
    }

    public final Long component7() {
        return this.autoDismissDuration;
    }

    public final long component8() {
        return this.taskId;
    }

    public final LiveCardType component9() {
        return this.type;
    }

    public final IslandSession copy(IslandWidget r210, IslandWidget r211, IslandWidget r212, IslandWidget r213, PendingIntent r214, IslandCardCallback r215, Long r216, long r217, LiveCardType r310, IslandWidget r311, Boolean r312, JsonObject r313, long r314, Object r315, ISceneEntity r316, Long r317, int r410) {
        return new IslandSession(r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r316, r317, r410);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        long r100 = this.taskId;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final void refreshScene() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        IslandApi r101 = ILiveCard.Companion.getInst().getIslandService();     // Catch: Throwable -> L8
        if (r101 == null) goto L5;
        r101.refreshScene(this);     // Catch: Throwable -> L8
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L8
        return;
    L5:
        r102 = null;
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public String toString() {
        return "IslandSession(collapseWidget=" + this.collapseWidget + ", expandWidget=" + this.expandWidget + ", nodeWidget=" + this.nodeWidget + ", notificationWidget=" + this.notificationWidget + ", intent=" + this.intent + ", autoDismissDuration=" + this.autoDismissDuration + ", islandAutoDismissDuration=" + this.islandAutoDismissDuration + ", taskId=" + this.taskId + ", type=" + this.type + ", currWidget=" + this.currWidget + ", canFontShow=" + this.canFrontShow + ", flags=" + this.flags + ", sceneEntity=" + this.sceneEntity + ')';
    }

    public final void updateFlags() {
        IslandApi r100 = ILiveCard.Companion.getInst().getIslandService();
        if (r100 == null) goto L6;
        r100.updateSessionFlags(this);
        return;
    }

    public final Long getAutoDismissDuration() {
        return this.autoDismissDuration;
    }

    public final IslandCardCallback getCallback() {
        return this.callback;
    }

    public final Boolean getCanFrontShow() {
        return this.canFrontShow;
    }

    public final IslandWidget getCollapseWidget() {
        return this.collapseWidget;
    }

    public final IslandWidget getCurrWidget() {
        return this.currWidget;
    }

    public final IslandWidget getExpandWidget() {
        return this.expandWidget;
    }

    public final JsonObject getExt() {
        return this.ext;
    }

    public final long getFlags() {
        return this.flags;
    }

    public final PendingIntent getIntent() {
        return this.intent;
    }

    public final Long getIslandAutoDismissDuration() {
        return this.islandAutoDismissDuration;
    }

    public final IslandWidget getNodeWidget() {
        return this.nodeWidget;
    }

    public final IslandWidget getNotificationWidget() {
        return this.notificationWidget;
    }

    public final ISceneEntity getSceneEntity() {
        return this.sceneEntity;
    }

    public final Object getSessionContext() {
        return this.sessionContext;
    }

    public final long getTaskId() {
        return this.taskId;
    }

    public final LiveCardType getType() {
        return this.type;
    }

    public IslandSession(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this(CREATOR.access$readVersion(CREATOR, r100), r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(IslandSession.class, r101) == true) goto L13;
        return false;
    L13:
        if (this.taskId != 0) goto L15;
        return false;
    L15:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.obric.livecard.api.entity.IslandSession");
        if (this.taskId == ((IslandSession) r100).taskId) goto L20;
        return false;
    L20:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final Object getPriority(Continuation<? super Long> r100) throws IllegalStateException, IslandUnsupportedException {
        IslandApi r101 = ILiveCard.Companion.getInst().getIslandService();
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getPriority(this, r100);
    }

    public final void readFromParcel(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        CREATOR r101 = CREATOR;
        int r102 = CREATOR.access$readVersion(r101, r100);
        r100.readParcelable(IslandWidget.class.getClassLoader());
        r100.readParcelable(IslandWidget.class.getClassLoader());
        r100.readParcelable(PendingIntent.class.getClassLoader());
        Class r103 = Long.TYPE;
        Object r104 = r100.readValue(r103.getClassLoader());
        if ((r104 instanceof Long) == false) goto L5;
        Long r105 = (Long) r104;
    L5:
        this.taskId = r100.readLong();
        r100.readString();
        r100.readBoolean();
        String r106 = r100.readString();
        if (r106 == null) goto L8;
        JsonObject r107 = (JsonObject) GsonProtectorUtils.fromJson(new Gson(), r106, JsonObject.class);
    L9:
        this.ext = r107;
        if (r102 < 1) goto L13;
        r100.readLong();
    L13:
        if (r102 < 2) goto L16;
        r100.readParcelable(IslandWidget.class.getClassLoader());
        this.sceneEntity = CREATOR.access$parseSceneEntity(r101, r100.readString());
    L16:
        if (r102 < 3) goto L19;
        r100.readParcelable(IslandWidget.class.getClassLoader());
    L19:
        if (r102 < 4) goto L24;
        Object r108 = r100.readValue(r103.getClassLoader());
        if ((r108 instanceof Long) == false) goto L25;
        Long r109 = (Long) r108;
        return;
    L25:
        return;
    L24:
        return;
    L8:
        r107 = null;
        goto L9
    }

    public final void setCanFrontShow(Boolean r100) {
        this.canFrontShow = r100;
    }

    public final void setCurrWidget(IslandWidget r100) {
        this.currWidget = r100;
    }

    public final void setExt(JsonObject r100) {
        this.ext = r100;
    }

    public final void setFlags(long r100) {
        this.flags = r100;
    }

    public final void setIntent(PendingIntent r100) {
        this.intent = r100;
    }

    public final void setNodeWidget(IslandWidget r100) {
        this.nodeWidget = r100;
    }

    public final void setNotificationWidget(IslandWidget r100) {
        this.notificationWidget = r100;
    }

    public final void setPriority(long r100) throws IllegalArgumentException, IslandUnsupportedException {
        IslandApi r101 = ILiveCard.Companion.getInst().getIslandService();
        if (r101 == null) goto L6;
        r101.setPriority(this, r100);
        return;
    }

    public final void setSceneEntity(ISceneEntity r100) {
        this.sceneEntity = r100;
    }

    public final void setSessionContext(Object r100) {
        this.sessionContext = r100;
    }

    public final void setTaskId(long r100) {
        this.taskId = r100;
    }

    public final void update(IslandWidget r100) {
        Intrinsics.checkNotNullParameter(r100, "targetWidget");
        IslandApi r101 = ILiveCard.Companion.getInst().getIslandService();
        if (r101 == null) goto L6;
        r101.updateWidget(this, r100);
        return;
    }

    private IslandSession(int r210, Parcel r211) {
        IslandWidget r100 = (IslandWidget) r211.readParcelable(IslandWidget.class.getClassLoader());
        IslandWidget r101 = (IslandWidget) r211.readParcelable(IslandWidget.class.getClassLoader());
        PendingIntent r102 = (PendingIntent) r211.readParcelable(PendingIntent.class.getClassLoader());
        Class r103 = Long.TYPE;
        Object r104 = r211.readValue(r103.getClassLoader());
        if ((r104 instanceof Long) == false) goto L5;
        Long r105 = (Long) r104;
    L6:
        long r106 = r211.readLong();
        LiveCardType.Companion r107 = LiveCardType.Companion;
        String r108 = r211.readString();
        if (r108 != null) goto L9;
        r108 = "";
    L9:
        LiveCardType r110 = r107.fromString(r108);
        boolean r109 = r211.readBoolean();
        String r111 = r211.readString();
        if (r111 == null) goto L12;
        JsonObject r112 = (JsonObject) GsonProtectorUtils.fromJson(new Gson(), r111, JsonObject.class);
    L14:
        if (r210 < 1) goto L16;
        long r113 = r211.readLong();
    L17:
        long r114 = r113;
        if (r210 < 2) goto L20;
        IslandWidget r115 = IslandSessionEntityKt.readWidgetFromParcel(r211);
    L21:
        if (r210 < 2) goto L23;
        ISceneEntity r212 = CREATOR.access$parseSceneEntity(CREATOR, r211.readString());
    L25:
        if (r210 < 3) goto L27;
        IslandWidget r213 = IslandSessionEntityKt.readWidgetFromParcel(r211);
    L29:
        if (r210 < 4) goto L33;
        Object r116 = r211.readValue(r103.getClassLoader());
        if ((r116 instanceof Long) == false) goto L33;
        Long r214 = (Long) r116;
    L34:
        this(r100, r101, r115, r213, r102, null, r105, r106, r110, null, Boolean.valueOf(r109), r112, r114, null, r212, r214, r210);
        return;
    L33:
        r214 = null;
        goto L34
    L27:
        r213 = null;
        goto L29
    L23:
        r212 = null;
        goto L25
    L20:
        r115 = null;
        goto L21
    L16:
        r113 = 0;
        goto L17
    L12:
        r112 = null;
        goto L14
    L5:
        r105 = null;
        goto L6
    }

    public final Object updateAnimation(IslandWidget r100, Continuation<? super Unit> r101) {
        IslandApi r102 = ILiveCard.Companion.getInst().getIslandService();
        if (r102 == null) goto L10;
        Object r103 = r102.updateAnimation(this, r100, r101);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r103;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        boolean r102 = false;
        if (1 != r101) goto L5;
        int r103 = this.version;
    L10:
        if (r103 <= 0) goto L12;
        r100.writeInt(MAGIC_CODE);
        r100.writeInt(4);
    L12:
        r100.writeParcelable(this.collapseWidget, r101);
        r100.writeParcelable(this.expandWidget, r101);
        r100.writeParcelable(this.intent, r101);
        r100.writeValue(this.autoDismissDuration);
        r100.writeLong(this.taskId);
        LiveCardType r104 = this.type;
        String r105 = null;
        if (r104 == null) goto L15;
        String r106 = r104.name();
    L16:
        r100.writeString(r106);
        Boolean r107 = this.canFrontShow;
        if (r107 == null) goto L19;
        r102 = r107.booleanValue();
    L19:
        r100.writeBoolean(r102);
        JsonObject r108 = this.ext;
        if (r108 == null) goto L22;
        String r109 = GsonProtectorUtils.toJson(new Gson(), r108);
    L23:
        r100.writeString(r109);
        if (r103 < 1) goto L27;
        r100.writeLong(this.flags);
    L27:
        if (r103 < 2) goto L33;
        r100.writeParcelable(this.nodeWidget, r101);
        ISceneEntity r110 = this.sceneEntity;
        if (r110 == null) goto L31;
        r105 = GsonProtectorUtils.toJson(SceneEntityParser.INSTANCE.getGson(), r110);
    L31:
        r100.writeString(r105);
    L33:
        if (r103 < 3) goto L35;
        r100.writeParcelable(this.notificationWidget, r101);
    L35:
        if (r103 < 4) goto L38;
        r100.writeValue(this.islandAutoDismissDuration);
        return;
    L38:
        return;
    L22:
        r109 = null;
        goto L23
    L15:
        r106 = null;
        goto L16
    L5:
        IslandApi r111 = ILiveCard.Companion.getInst().getIslandService();
        if (r111 == null) goto L8;
        r103 = r111.getIslandVersion();
        goto L10
    L8:
        r103 = 0;
        goto L10
    }

    private final void sendEventInner(IslandWidget r100, String r101, String r102) {
        IslandApi r103 = ILiveCard.Companion.getInst().getIslandService();
        if (r103 == null) goto L6;
        r103.sendEvent(this, r100, r101, r102);
        return;
    }

    public final void sendAnyEvent(IslandWidget r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "targetWidget");
        Intrinsics.checkNotNullParameter(r101, b.f276361k);
        String r103 = null;
        if ((r102 instanceof JsonObject) == false) goto L5;
        JsonObject r104 = (JsonObject) r102;
    L6:
        if (r104 == null) goto L10;
        sendEvent(r100, r101, r104);
        return;
    L10:
        if ((r102 instanceof String) == false) goto L12;
        String r105 = (String) r102;
    L13:
        if (r105 == null) goto L16;
        sendEventInner(r100, r101, r105);
        return;
    L16:
        if (r102 == null) goto L18;
        r103 = GsonProtectorUtils.toJson(new Gson(), r102);
    L18:
        sendEventInner(r100, r101, r103);
        return;
    L12:
        r105 = null;
        goto L13
    L5:
        r104 = null;
        goto L6
    }

    public final void sendEvent(IslandWidget r100, String r101, JsonObject r102) {
        Intrinsics.checkNotNullParameter(r100, "targetWidget");
        Intrinsics.checkNotNullParameter(r101, b.f276361k);
        if (r102 == null) goto L5;
        String r103 = r102.toString();
    L6:
        sendEventInner(r100, r101, r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public IslandSession(IslandWidget r100, IslandWidget r101, IslandWidget r102, IslandWidget r103, PendingIntent r104, IslandCardCallback r105, Long r110, long r111, LiveCardType r112, IslandWidget r113, Boolean r114, JsonObject r115, long r116, Object r117, ISceneEntity r210, Long r211, int r212) {
        this.collapseWidget = r100;
        this.expandWidget = r101;
        this.nodeWidget = r102;
        this.notificationWidget = r103;
        this.intent = r104;
        this.callback = r105;
        this.autoDismissDuration = r110;
        this.taskId = r111;
        this.type = r112;
        this.currWidget = r113;
        this.canFrontShow = r114;
        this.ext = r115;
        this.flags = r116;
        this.sessionContext = r117;
        this.sceneEntity = r210;
        this.islandAutoDismissDuration = r211;
        this.version = r212;
    }

    public /* synthetic */ IslandSession(IslandWidget r210, IslandWidget r211, IslandWidget r212, IslandWidget r213, PendingIntent r214, IslandCardCallback r215, Long r216, long r217, LiveCardType r310, IslandWidget r311, Boolean r312, JsonObject r313, long r314, Object r315, ISceneEntity r316, Long r317, int r318, int r410, DefaultConstructorMarker r411) {
        if ((r410 & 1) == 0) goto L5;
        IslandWidget r100 = null;
    L7:
        if ((r410 & 2) == 0) goto L9;
        IslandWidget r101 = null;
    L11:
        if ((r410 & 4) == 0) goto L13;
        IslandWidget r102 = null;
    L15:
        if ((r410 & 8) == 0) goto L17;
        IslandWidget r103 = null;
    L19:
        if ((r410 & 16) == 0) goto L21;
        PendingIntent r104 = null;
    L23:
        if ((r410 & 32) == 0) goto L25;
        IslandCardCallback r105 = null;
    L27:
        if ((r410 & 64) == 0) goto L29;
        Long r106 = null;
    L31:
        if ((r410 & 128) == 0) goto L33;
        long r110 = 0;
    L35:
        if ((r410 & 256) == 0) goto L37;
        LiveCardType r107 = null;
    L39:
        if ((r410 & 512) == 0) goto L41;
        IslandWidget r111 = null;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        Boolean r112 = Boolean.FALSE;
    L47:
        if ((r410 & 2048) == 0) goto L49;
        JsonObject r108 = null;
    L51:
        if ((r410 & 4096) == 0) goto L53;
        long r113 = 0;
    L54:
        long r114 = r113;
        if ((r410 & 8192) == 0) goto L57;
        Object r115 = null;
    L59:
        if ((r410 & 16384) == 0) goto L61;
        ISceneEntity r116 = null;
    L63:
        if ((r410 & 32768) == 0) goto L65;
        Long r117 = null;
    L67:
        if ((r410 & 65536) == 0) goto L69;
        int r109 = 4;
    L70:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r107, r111, r112, r108, r114, r115, r116, r117, r109);
        return;
    L69:
        r109 = r318;
        goto L70
    L65:
        r117 = r317;
        goto L67
    L61:
        r116 = r316;
        goto L63
    L57:
        r115 = r315;
        goto L59
    L53:
        r113 = r314;
        goto L54
    L49:
        r108 = r313;
        goto L51
    L45:
        r112 = r312;
        goto L47
    L41:
        r111 = r311;
        goto L43
    L37:
        r107 = r310;
        goto L39
    L33:
        r110 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
