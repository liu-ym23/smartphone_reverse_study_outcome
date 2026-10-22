package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.capabilitykit.entity.EntityExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BY\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b¢\u0006\u0002\u0010\u0013J\b\u0010(\u001a\u00020)H\u0016J\"\u0010*\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00101\u001a\u00020/H\u0016R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0012\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00063"}, d2 = {"Lcom/obric/capabilitykit/entity/app/MusicEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", "artists", "", "Lcom/obric/capabilitykit/entity/app/Artist;", "cover", "Lcom/obric/capabilitykit/entity/app/Cover;", "preview", "Lcom/obric/capabilitykit/entity/app/Preview;", "duration", "(Ljava/lang/String;JJLjava/lang/String;Ljava/util/List;Lcom/obric/capabilitykit/entity/app/Cover;Lcom/obric/capabilitykit/entity/app/Preview;J)V", "getArtists", "()Ljava/util/List;", "setArtists", "(Ljava/util/List;)V", "getCover", "()Lcom/obric/capabilitykit/entity/app/Cover;", "setCover", "(Lcom/obric/capabilitykit/entity/app/Cover;)V", "getDuration", "()J", "setDuration", "(J)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPreview", "()Lcom/obric/capabilitykit/entity/app/Preview;", "setPreview", "(Lcom/obric/capabilitykit/entity/app/Preview;)V", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MusicEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private List<Artist> artists;
    private Cover cover;
    private long duration;
    private String name;
    private Preview preview;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/MusicEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/MusicEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/MusicEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<MusicEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.MusicEntity");
            return (MusicEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MusicEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicEntity[] newArray(int r100) {
            return new MusicEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MusicEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/obric/capabilitykit/entity/app/Artist;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/obric/capabilitykit/entity/app/Artist;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class a extends Lambda implements Function1<Artist, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f396251a = null;

        static {
            f396251a = new a();
        }

        public a() {
            super(1);
        }

        public final CharSequence a(Artist r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return r100.getName();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Artist r100) {
            return a(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MusicEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(EntityExtKt.e(r110), r110.readLong(), r110.readLong(), EntityExtKt.e(r110), r110.createTypedArrayList(Artist.CREATOR), (Cover) r110.readParcelable(Cover.class.getClassLoader()), (Preview) r110.readParcelable(Preview.class.getClassLoader()), r110.readLong());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 0, r110.readInt());
    }

    public MusicEntity(String r110, long r111, long r112, String r113, List<Artist> r114, Cover r115, Preview r116, long r117) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r113, "name");
        super(r110, r111, r112, 1801);
        this.name = r113;
        this.artists = r114;
        this.cover = r115;
        this.preview = r116;
        this.duration = r117;
    }

    public /* synthetic */ MusicEntity(String r110, long r111, long r112, String r210, List r211, Cover r212, Preview r213, long r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 16) == 0) goto L5;
        List r113 = null;
    L7:
        if ((r215 & 32) == 0) goto L9;
        Cover r114 = null;
    L11:
        if ((r215 & 64) == 0) goto L13;
        Preview r115 = null;
    L15:
        if ((r215 & 128) == 0) goto L17;
        long r116 = 0;
    L18:
        this(r110, r111, r112, r210, r113, r114, r115, r116);
        return;
    L17:
        r116 = r214;
        goto L18
    L13:
        r115 = r213;
        goto L15
    L9:
        r114 = r212;
        goto L11
    L5:
        r113 = r211;
        goto L7
    }

    public final List<Artist> getArtists() {
        return this.artists;
    }

    public final Cover getCover() {
        return this.cover;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        List<Artist> r100 = this.artists;
        if (r100 == null) goto L5;
        String r101 = CollectionsKt.joinToString$default(r100, ", ", null, null, 0, null, a.f396251a, 30, null);
    L6:
        String r102 = this.name;
        return new DisplayRepresentation(null, r102, r101, getLastModifiedTime());
    L5:
        r101 = null;
        goto L6
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getName() {
        return this.name;
    }

    public final Preview getPreview() {
        return this.preview;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    public final void setArtists(List<Artist> r100) {
        this.artists = r100;
    }

    public final void setCover(Cover r100) {
        this.cover = r100;
    }

    public final void setDuration(long r100) {
        this.duration = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setPreview(Preview r100) {
        this.preview = r100;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeString(this.name);
        r100.writeTypedList(this.artists);
        r100.writeParcelable(this.cover, r101);
        r100.writeParcelable(this.preview, r101);
        r100.writeLong(this.duration);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeInt(0);
    }
}
