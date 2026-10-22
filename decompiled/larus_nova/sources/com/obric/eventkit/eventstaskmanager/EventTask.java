package com.obric.eventkit.eventstaskmanager;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0017\u0018\u0000 J2\u00020\u0001:\u0001KBc\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\u0016\b\u0002\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u000103¢\u0006\u0004\bH\u0010IJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\tJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\u0017\u0010\u0016\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR$\u0010#\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R$\u0010-\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R0\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u0001038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010:\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0017\u001a\u0004\b;\u0010\u0019\"\u0004\b<\u0010=R$\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010E\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010\u001c\u001a\u0004\bF\u0010\u001e\"\u0004\bG\u0010 ¨\u0006L"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/EventTask;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "writeExtensionFieldToParcel$eventstaskkit_release", "(Landroid/os/Parcel;)V", "writeExtensionFieldToParcel", "readExtensionFieldFromParcel$eventstaskkit_release", "readExtensionFieldFromParcel", "ourVersion", "readSubClassExtensionFieldFromParcel$eventstaskkit_release", "(Landroid/os/Parcel;I)V", "readSubClassExtensionFieldFromParcel", "Ljava/lang/ClassLoader;", "currentClassLoader", "version", "onReadSubClassExtensionField", "describeContents", "type", "I", "getType", "()I", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "taskStatus", "Ljava/lang/Integer;", "getTaskStatus", "()Ljava/lang/Integer;", "setTaskStatus", "(Ljava/lang/Integer;)V", "enableStatus", "getEnableStatus", "setEnableStatus", "", "createTime", "Ljava/lang/Long;", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "", "ext", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "taskMode", "getTaskMode", "setTaskMode", "(I)V", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "taskKnowledge", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "getTaskKnowledge", "()Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "setTaskKnowledge", "(Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;)V", GXTemplateKey.GAIAX_TEMPLATE_ID, "getTemplateId", "setTemplateId", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public class EventTask implements Parcelable {
    public static final Parcelable.Creator<EventTask> CREATOR = null;
    public static final b Companion = null;
    private static final int FIELD_VERSION = 3;
    private Long createTime;
    private Integer enableStatus;
    private Map<String, String> ext;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f396873id;
    private final String name;
    private TaskKnowledge taskKnowledge;
    private int taskMode;
    private Integer taskStatus;
    private String templateId;
    private final int type;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<EventTask> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EventTask createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            int r100 = r110.readInt();
            String r101 = TimerTaskKt.a(r110);
            String r102 = TimerTaskKt.a(r110);
            int r103 = r110.readInt();
            int r104 = r110.readInt();
            long r105 = r110.readLong();
            if (Build.VERSION.SDK_INT < 33) goto L7;
            LinkedHashMap r106 = new LinkedHashMap();
            r110.readMap(r106, String.class.getClassLoader(), String.class, String.class);
            if ((!r106.isEmpty()) == true) goto L19;
        L18:
            r106 = null;
        L19:
            if (r100 == 1) goto L29;
            if (r100 == 2) goto L36;
            if (r100 != 3) goto L26;
            return new ShortcutTask(r101, r102, Integer.valueOf(r103), Integer.valueOf(r104), Long.valueOf(r105), r106, r110);
        L26:
            throw new IllegalArgumentException("Unknown event task type: " + r100);
        L36:
            return new ConditionTask(r101, r102, Integer.valueOf(r103), Integer.valueOf(r104), Long.valueOf(r105), r106, r110);
        L29:
            return new TimerTaskV2(r101, r102, Integer.valueOf(r103), Integer.valueOf(r104), Long.valueOf(r105), r106, r110);
        L7:
            Bundle r107 = r110.readBundle(EventTask.class.getClassLoader());
            if (r107 == null) goto L18;
            LinkedHashMap r108 = new LinkedHashMap();
            Iterator<T> r111 = r107.keySet().iterator();
        L11:
            if (r111.hasNext() == false) goto L16;
            String r112 = (String) r111.next();
            String r113 = r107.getString(r112);
            if (r113 == null) goto L11;
            r108.put(r112, r113);
            goto L11
        L16:
            if ((!r108.isEmpty()) == false) goto L18;
            r106 = r108;
            goto L19
        }

        @Override // android.os.Parcelable.Creator
        public final EventTask[] newArray(int r100) {
            return new EventTask[r100];
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
        CREATOR = new a();
    }

    public EventTask(int r100, String r101, String r102, Integer r103, Integer r104, Long r105, Map<String, String> r106) {
        this.type = r100;
        this.f396873id = r101;
        this.name = r102;
        this.taskStatus = r103;
        this.enableStatus = r104;
        this.createTime = r105;
        this.ext = r106;
    }

    public /* synthetic */ EventTask(int r100, String r101, String r110, Integer r111, Integer r112, Long r113, Map r114, int r115, DefaultConstructorMarker r116) {
        Map r102 = null;
        if ((r115 & 2) == 0) goto L5;
        String r103 = null;
    L7:
        if ((r115 & 4) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r115 & 8) == 0) goto L13;
        Integer r105 = null;
    L15:
        if ((r115 & 16) == 0) goto L17;
        Integer r106 = null;
    L19:
        if ((r115 & 32) == 0) goto L21;
        Long r107 = null;
    L23:
        if ((r115 & 64) != 0) goto L26;
        r102 = r114;
    L26:
        this(r100, r103, r104, r105, r106, r107, r102);
        return;
    L21:
        r107 = r113;
        goto L23
    L17:
        r106 = r112;
        goto L19
    L13:
        r105 = r111;
        goto L15
    L9:
        r104 = r110;
        goto L11
    L5:
        r103 = r101;
        goto L7
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public Integer getEnableStatus() {
        return this.enableStatus;
    }

    public Map<String, String> getExt() {
        return this.ext;
    }

    public String getId() {
        return this.f396873id;
    }

    public String getName() {
        return this.name;
    }

    public final TaskKnowledge getTaskKnowledge() {
        return this.taskKnowledge;
    }

    public final int getTaskMode() {
        return this.taskMode;
    }

    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final int getType() {
        return this.type;
    }

    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    public final void readExtensionFieldFromParcel$eventstaskkit_release(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        int r100 = r110.readInt();
        ClassLoader r101 = EventTask.class.getClassLoader();
        if (r100 <= 3) goto L5;
        int r102 = 3;
    L6:
        int r103 = 1;
    L7:
        if (r103 > r102) goto L23;
        if (r103 == 1) goto L21;
        TaskKnowledge r104 = null;
        String r105 = null;
        if (r103 == 2) goto L17;
        if (r103 != 3) goto L22;
        Object r106 = r110.readValue(r101);
        if ((r106 instanceof String) == false) goto L16;
        r105 = (String) r106;
    L16:
        this.templateId = r105;
    L22:
        r103 = r103 + 1;
        goto L7
    L17:
        Object r107 = ParcelUtils.INSTANCE.readValueSafely(r110, r101);
        if ((r107 instanceof TaskKnowledge) == false) goto L20;
        r104 = (TaskKnowledge) r107;
    L20:
        this.taskKnowledge = r104;
        goto L22
    L21:
        Object r108 = r110.readValue(r101);
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type kotlin.Int");
        this.taskMode = ((Integer) r108).intValue();
    L23:
        if (r103 > r100) goto L25;
        ParcelUtils.INSTANCE.skipValueSafely(r110, r101);
        r103 = r103 + 1;
        goto L23
    L25:
        return;
    L5:
        r102 = r100;
        goto L6
    }

    public final void readSubClassExtensionFieldFromParcel$eventstaskkit_release(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        int r102 = r100.readInt();
        if (r102 > r101) goto L6;
        r101 = r102;
    L6:
        ClassLoader r103 = EventTask.class.getClassLoader();
        int r104 = 1;
    L7:
        if (r104 > r101) goto L9;
        onReadSubClassExtensionField(r100, r103, r104);
        r104 = r104 + 1;
    L9:
        if (r104 > r102) goto L11;
        ParcelUtils.INSTANCE.skipValueSafely(r100, r103);
        r104 = r104 + 1;
        goto L9
    }

    public void setCreateTime(Long r100) {
        this.createTime = r100;
    }

    public void setEnableStatus(Integer r100) {
        this.enableStatus = r100;
    }

    public void setExt(Map<String, String> r100) {
        this.ext = r100;
    }

    public void setId(String r100) {
        this.f396873id = r100;
    }

    public final void setTaskKnowledge(TaskKnowledge r100) {
        this.taskKnowledge = r100;
    }

    public final void setTaskMode(int r100) {
        this.taskMode = r100;
    }

    public void setTaskStatus(Integer r100) {
        this.taskStatus = r100;
    }

    public final void setTemplateId(String r100) {
        this.templateId = r100;
    }

    public final void writeExtensionFieldToParcel$eventstaskkit_release(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(3);
        r100.writeValue(Integer.valueOf(this.taskMode));
        r100.writeValue(this.taskKnowledge);
        r100.writeValue(this.templateId);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.type);
        r100.writeString(getId());
        r100.writeString(getName());
        Integer r102 = getTaskStatus();
        int r103 = -1;
        if (r102 == null) goto L5;
        int r104 = r102.intValue();
    L6:
        r100.writeInt(r104);
        Integer r105 = getEnableStatus();
        if (r105 == null) goto L9;
        r103 = r105.intValue();
    L9:
        r100.writeInt(r103);
        Long r106 = getCreateTime();
        if (r106 == null) goto L12;
        long r107 = r106.longValue();
    L13:
        r100.writeLong(r107);
        if (Build.VERSION.SDK_INT < 33) goto L16;
        r100.writeMap(getExt());
        return;
    L16:
        Bundle r108 = new Bundle();
        Map<String, String> r109 = getExt();
        if (r109 == null) goto L22;
        Iterator<Map.Entry<String, String>> r110 = r109.entrySet().iterator();
    L20:
        if (r110.hasNext() == false) goto L22;
        Map.Entry<String, String> r111 = r110.next();
        r108.putString(r111.getKey(), r111.getValue());
    L22:
        r100.writeBundle(r108);
        return;
    L12:
        r107 = -1;
        goto L13
    L5:
        r104 = -1;
        goto L6
    }
}
