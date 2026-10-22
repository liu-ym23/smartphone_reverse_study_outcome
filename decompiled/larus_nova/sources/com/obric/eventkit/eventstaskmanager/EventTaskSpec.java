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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\t\b\u0017\u0018\u0000 52\u00020\u0001:\u00016Bo\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010.¢\u0006\u0004\b3\u00104J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\tJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\u0017\u0010\u0016\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010\u001eR\u001c\u0010*\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010 \u001a\u0004\b+\u0010\"R\u001c\u0010,\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010 \u001a\u0004\b-\u0010\"R(\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010.8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00067"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "writeExtensionFieldToParcel$eventstaskkit_release", "(Landroid/os/Parcel;)V", "writeExtensionFieldToParcel", "readExtensionFieldFromParcel$eventstaskkit_release", "readExtensionFieldFromParcel", "ourVersion", "readSubClassExtensionFieldFromParcel$eventstaskkit_release", "(Landroid/os/Parcel;I)V", "readSubClassExtensionFieldFromParcel", "Ljava/lang/ClassLoader;", "currentClassLoader", "version", "onReadSubClassExtensionField", "describeContents", "type", "I", "getType", "()I", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "taskMode", "Ljava/lang/Integer;", "getTaskMode", "()Ljava/lang/Integer;", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "taskKnowledge", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "getTaskKnowledge", "()Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", GXTemplateKey.GAIAX_TEMPLATE_ID, "getTemplateId", "taskStatus", "getTaskStatus", "enableStatus", "getEnableStatus", "", "ext", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "<init>", "(ILjava/lang/String;Ljava/lang/Integer;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public class EventTaskSpec implements Parcelable {
    public static final Parcelable.Creator<EventTaskSpec> CREATOR = null;
    public static final b Companion = null;
    private static final int FIELD_VERSION = 0;
    private final Integer enableStatus;
    private final Map<String, String> ext;
    private final String name;
    private final TaskKnowledge taskKnowledge;
    private final Integer taskMode;
    private final Integer taskStatus;
    private final String templateId;
    private final int type;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<EventTaskSpec> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EventTaskSpec createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            int r100 = r110.readInt();
            String r101 = r110.readString();
            int r102 = r110.readInt();
            TaskKnowledge r103 = (TaskKnowledge) r110.readParcelable(EventTaskSpec.class.getClassLoader());
            String r104 = r110.readString();
            int r105 = r110.readInt();
            int r106 = r110.readInt();
            if (Build.VERSION.SDK_INT < 33) goto L7;
            LinkedHashMap r107 = new LinkedHashMap();
            r110.readMap(r107, String.class.getClassLoader(), String.class, String.class);
            if ((!r107.isEmpty()) == true) goto L19;
        L18:
            r107 = null;
        L19:
            LinkedHashMap r108 = r107;
        L21:
            if (r100 == 2) goto L28;
            if (r100 != 3) goto L26;
            return new ShortcutTaskSpec(r101, Integer.valueOf(r102), r103, r104, Integer.valueOf(r105), Integer.valueOf(r106), r108, r110);
        L26:
            throw new IllegalArgumentException("Unknown event task type: " + r100);
        L28:
            return new ConditionTaskSpec(r101, Integer.valueOf(r102), r103, r104, Integer.valueOf(r105), Integer.valueOf(r106), r108, r110);
        L7:
            Bundle r109 = r110.readBundle(EventTaskSpec.class.getClassLoader());
            if (r109 == null) goto L18;
            r108 = new LinkedHashMap();
            Iterator<T> r111 = r109.keySet().iterator();
        L11:
            if (r111.hasNext() == false) goto L16;
            String r112 = (String) r111.next();
            String r113 = r109.getString(r112);
            if (r113 == null) goto L11;
            r108.put(r112, r113);
            goto L11
        L16:
            if ((!r108.isEmpty()) == false) goto L18;
            goto L18
        }

        @Override // android.os.Parcelable.Creator
        public final EventTaskSpec[] newArray(int r100) {
            return new EventTaskSpec[r100];
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

    public EventTaskSpec(int r100, String r101, Integer r102, TaskKnowledge r103, String r104, Integer r105, Integer r106, Map<String, String> r107) {
        this.type = r100;
        this.name = r101;
        this.taskMode = r102;
        this.taskKnowledge = r103;
        this.templateId = r104;
        this.taskStatus = r105;
        this.enableStatus = r106;
        this.ext = r107;
    }

    public /* synthetic */ EventTaskSpec(int r100, String r110, Integer r111, TaskKnowledge r112, String r113, Integer r114, Integer r115, Map r116, int r117, DefaultConstructorMarker r118) {
        Map r101 = null;
        if ((r117 & 2) == 0) goto L5;
        String r102 = null;
    L7:
        if ((r117 & 4) == 0) goto L9;
        Integer r103 = null;
    L11:
        if ((r117 & 8) == 0) goto L13;
        TaskKnowledge r104 = null;
    L15:
        if ((r117 & 16) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r117 & 32) == 0) goto L21;
        Integer r106 = null;
    L23:
        if ((r117 & 64) == 0) goto L25;
        Integer r107 = null;
    L27:
        if ((r117 & 128) != 0) goto L30;
        r101 = r116;
    L30:
        this(r100, r102, r103, r104, r105, r106, r107, r101);
        return;
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r102 = r110;
        goto L7
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Integer getEnableStatus() {
        return this.enableStatus;
    }

    public Map<String, String> getExt() {
        return this.ext;
    }

    public String getName() {
        return this.name;
    }

    public TaskKnowledge getTaskKnowledge() {
        return this.taskKnowledge;
    }

    public Integer getTaskMode() {
        return this.taskMode;
    }

    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public final int getType() {
        return this.type;
    }

    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    public final void readExtensionFieldFromParcel$eventstaskkit_release(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        int r101 = r100.readInt();
        ClassLoader r102 = EventTaskSpec.class.getClassLoader();
        if (r101 <= 0) goto L5;
        int r103 = 0;
    L6:
        int r104 = 1;
    L7:
        if (r104 > r103) goto L9;
        r104 = r104 + 1;
    L9:
        if (r104 > r101) goto L11;
        ParcelUtils.INSTANCE.skipValueSafely(r100, r102);
        r104 = r104 + 1;
        goto L9
    L11:
        return;
    L5:
        r103 = r101;
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

    public final void writeExtensionFieldToParcel$eventstaskkit_release(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.type);
        r100.writeString(getName());
        Integer r102 = getTaskMode();
        int r103 = -1;
        if (r102 == null) goto L5;
        int r104 = r102.intValue();
    L6:
        r100.writeInt(r104);
        r100.writeParcelable(getTaskKnowledge(), r101);
        r100.writeString(getTemplateId());
        Integer r105 = getTaskStatus();
        if (r105 == null) goto L9;
        int r106 = r105.intValue();
    L10:
        r100.writeInt(r106);
        Integer r107 = getEnableStatus();
        if (r107 == null) goto L13;
        r103 = r107.intValue();
    L13:
        r100.writeInt(r103);
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
    L9:
        r106 = -1;
        goto L10
    L5:
        r104 = -1;
        goto L6
    }
}
