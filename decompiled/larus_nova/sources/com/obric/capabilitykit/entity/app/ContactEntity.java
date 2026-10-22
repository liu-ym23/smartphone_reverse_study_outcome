package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.GenderEnum;
import com.obric.capabilitykit.entity.meta.MetaAddress;
import com.obric.capabilitykit.entity.meta.MetaAnniversary;
import com.obric.capabilitykit.entity.meta.MetaCredentialNumber;
import com.obric.capabilitykit.entity.meta.MetaEmailAddress;
import com.obric.capabilitykit.entity.meta.MetaInstantMessaging;
import com.obric.capabilitykit.entity.meta.MetaRelationship;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0001hB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B7\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ\b\u0010\\\u001a\u00020]H\u0016J\u000e\u0010^\u001a\b\u0012\u0004\u0012\u00020_0\rH\u0016J\"\u0010`\u001a\u00020a2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010d\u001a\u00020eH\u0016J\u0018\u0010f\u001a\u00020a2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010g\u001a\u00020eH\u0016R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015R\u001c\u0010)\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$R\"\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0013\"\u0004\b9\u0010\u0015R\u001c\u0010:\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\"\"\u0004\b<\u0010$R\u001c\u0010=\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010B\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\"\"\u0004\bI\u0010$R\u001c\u0010J\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\"\"\u0004\bL\u0010$R\"\u0010M\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0013\"\u0004\bP\u0010\u0015R\u001c\u0010Q\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\"\"\u0004\bS\u0010$R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0013\"\u0004\bU\u0010\u0015R\u001c\u0010V\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\"\"\u0004\bX\u0010$R\"\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0013\"\u0004\b[\u0010\u0015¨\u0006i"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ContactEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", "telephones", "", "Lcom/obric/capabilitykit/entity/meta/MetaTelephone;", "(Ljava/lang/String;JJLjava/lang/String;Ljava/util/List;)V", "addresses", "Lcom/obric/capabilitykit/entity/meta/MetaAddress;", "getAddresses", "()Ljava/util/List;", "setAddresses", "(Ljava/util/List;)V", "anniversaries", "Lcom/obric/capabilitykit/entity/meta/MetaAnniversary;", "getAnniversaries", "setAnniversaries", "avatar", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "getAvatar", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "setAvatar", "(Lcom/obric/capabilitykit/entity/app/FileEntity;)V", "company", "getCompany", "()Ljava/lang/String;", "setCompany", "(Ljava/lang/String;)V", "credentialNumbers", "Lcom/obric/capabilitykit/entity/meta/MetaCredentialNumber;", "getCredentialNumbers", "setCredentialNumbers", "department", "getDepartment", "setDepartment", "emails", "Lcom/obric/capabilitykit/entity/meta/MetaEmailAddress;", "getEmails", "setEmails", "gender", "Lcom/obric/capabilitykit/entity/enums/GenderEnum;", "getGender", "()Lcom/obric/capabilitykit/entity/enums/GenderEnum;", "setGender", "(Lcom/obric/capabilitykit/entity/enums/GenderEnum;)V", "instantMessagings", "Lcom/obric/capabilitykit/entity/meta/MetaInstantMessaging;", "getInstantMessagings", "setInstantMessagings", "jobTitle", "getJobTitle", "setJobTitle", "lastUsedTelephone", "getLastUsedTelephone", "()Lcom/obric/capabilitykit/entity/meta/MetaTelephone;", "setLastUsedTelephone", "(Lcom/obric/capabilitykit/entity/meta/MetaTelephone;)V", "lastUsedTelephoneTimeStamp", "getLastUsedTelephoneTimeStamp", "()Ljava/lang/Long;", "setLastUsedTelephoneTimeStamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getName", "setName", "note", "getNote", "setNote", "relationShips", "Lcom/obric/capabilitykit/entity/meta/MetaRelationship;", "getRelationShips", "setRelationShips", "subNote", "getSubNote", "setSubNote", "getTelephones", "setTelephones", "voip", "getVoip", "setVoip", "websites", "getWebsites", "setWebsites", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ContactEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 6;
    private static final int RELATED_VERSION = 1;
    private List<MetaAddress> addresses;
    private List<MetaAnniversary> anniversaries;
    private FileEntity avatar;
    private String company;
    private List<MetaCredentialNumber> credentialNumbers;
    private String department;
    private List<MetaEmailAddress> emails;
    private GenderEnum gender;
    private List<MetaInstantMessaging> instantMessagings;
    private String jobTitle;
    private MetaTelephone lastUsedTelephone;
    private Long lastUsedTelephoneTimeStamp;
    private String name;
    private String note;
    private List<MetaRelationship> relationShips;
    private String subNote;
    private List<MetaTelephone> telephones;
    private String voip;
    private List<String> websites;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ContactEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/ContactEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<ContactEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.ContactEntity");
            return (ContactEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 7;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactEntity[] newArray(int r100) {
            return new ContactEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaTelephone;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/obric/capabilitykit/entity/meta/MetaTelephone;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class a extends Lambda implements Function1<MetaTelephone, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f396207a = null;

        static {
            f396207a = new a();
        }

        public a() {
            super(1);
        }

        public final CharSequence a(MetaTelephone r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return r100.getTelephone();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(MetaTelephone r100) {
            return a(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public ContactEntity(String r100, long r110, long r111, String r112, List<MetaTelephone> r113) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r112, "name");
        super(r100, r110, r111, 201);
        this.name = r112;
        this.telephones = r113;
    }

    public /* synthetic */ ContactEntity(String r110, long r111, long r112, String r113, List r114, int r115, DefaultConstructorMarker r116) {
        if ((r115 & 16) == 0) goto L5;
        List r100 = null;
    L6:
        this(r110, r111, r112, r113, r100);
        return;
    L5:
        r100 = r114;
        goto L6
    }

    public final List<MetaAddress> getAddresses() {
        return this.addresses;
    }

    public final List<MetaAnniversary> getAnniversaries() {
        return this.anniversaries;
    }

    public final FileEntity getAvatar() {
        return this.avatar;
    }

    public final String getCompany() {
        return this.company;
    }

    public final List<MetaCredentialNumber> getCredentialNumbers() {
        return this.credentialNumbers;
    }

    public final String getDepartment() {
        return this.department;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        List<MetaTelephone> r100 = this.telephones;
        Uri r101 = null;
        if (r100 == null) goto L5;
        String r102 = CollectionsKt.joinToString$default(r100, "\n", null, null, 0, null, a.f396207a, 30, null);
    L6:
        FileEntity r103 = this.avatar;
        if (r103 == null) goto L10;
        r101 = r103.getContentUrl();
    L10:
        return new DisplayRepresentation(r101, this.name, r102, getLastModifiedTime());
    L5:
        r102 = null;
        goto L6
    }

    public final List<MetaEmailAddress> getEmails() {
        return this.emails;
    }

    public final GenderEnum getGender() {
        return this.gender;
    }

    public final List<MetaInstantMessaging> getInstantMessagings() {
        return this.instantMessagings;
    }

    public final String getJobTitle() {
        return this.jobTitle;
    }

    public final MetaTelephone getLastUsedTelephone() {
        return this.lastUsedTelephone;
    }

    public final Long getLastUsedTelephoneTimeStamp() {
        return this.lastUsedTelephoneTimeStamp;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNote() {
        return this.note;
    }

    public final List<MetaRelationship> getRelationShips() {
        return this.relationShips;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        FileEntity r100 = this.avatar;
        if (r100 == null) goto L7;
        List<Uri> r101 = r100.getSharedUris();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return CollectionsKt.emptyList();
    }

    public final String getSubNote() {
        return this.subNote;
    }

    public final List<MetaTelephone> getTelephones() {
        return this.telephones;
    }

    public final String getVoip() {
        return this.voip;
    }

    public final List<String> getWebsites() {
        return this.websites;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        switch(r102) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L17;
        };
    L5:
        this.lastUsedTelephoneTimeStamp = (Long) r100.readValue(r101);
        return;
    L6:
        this.lastUsedTelephone = (MetaTelephone) r100.readValue(r101);
        return;
    L7:
        this.websites = (List) r100.readValue(r101);
        return;
    L8:
        this.subNote = (String) r100.readValue(r101);
        return;
    L9:
        this.department = (String) r100.readValue(r101);
        return;
    L10:
        this.jobTitle = (String) r100.readValue(r101);
        return;
    }

    public final void setAddresses(List<MetaAddress> r100) {
        this.addresses = r100;
    }

    public final void setAnniversaries(List<MetaAnniversary> r100) {
        this.anniversaries = r100;
    }

    public final void setAvatar(FileEntity r100) {
        this.avatar = r100;
    }

    public final void setCompany(String r100) {
        this.company = r100;
    }

    public final void setCredentialNumbers(List<MetaCredentialNumber> r100) {
        this.credentialNumbers = r100;
    }

    public final void setDepartment(String r100) {
        this.department = r100;
    }

    public final void setEmails(List<MetaEmailAddress> r100) {
        this.emails = r100;
    }

    public final void setGender(GenderEnum r100) {
        this.gender = r100;
    }

    public final void setInstantMessagings(List<MetaInstantMessaging> r100) {
        this.instantMessagings = r100;
    }

    public final void setJobTitle(String r100) {
        this.jobTitle = r100;
    }

    public final void setLastUsedTelephone(MetaTelephone r100) {
        this.lastUsedTelephone = r100;
    }

    public final void setLastUsedTelephoneTimeStamp(Long r100) {
        this.lastUsedTelephoneTimeStamp = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setNote(String r100) {
        this.note = r100;
    }

    public final void setRelationShips(List<MetaRelationship> r100) {
        this.relationShips = r100;
    }

    public final void setSubNote(String r100) {
        this.subNote = r100;
    }

    public final void setTelephones(List<MetaTelephone> r100) {
        this.telephones = r100;
    }

    public final void setVoip(String r100) {
        this.voip = r100;
    }

    public final void setWebsites(List<String> r100) {
        this.websites = r100;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeString(this.name);
        r100.writeTypedList(this.telephones);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeInt(6);
        r100.writeParcelable(this.avatar, r101);
        r100.writeString(this.note);
        GenderEnum r102 = this.gender;
        if (r102 == null) goto L5;
        String r103 = r102.name();
    L6:
        r100.writeString(r103);
        r100.writeTypedList(this.credentialNumbers);
        r100.writeTypedList(this.emails);
        r100.writeTypedList(this.addresses);
        r100.writeString(this.company);
        r100.writeTypedList(this.instantMessagings);
        r100.writeTypedList(this.anniversaries);
        r100.writeString(this.voip);
        r100.writeTypedList(this.relationShips);
        r100.writeValue(this.jobTitle);
        r100.writeValue(this.department);
        r100.writeValue(this.subNote);
        r100.writeValue(this.websites);
        r100.writeValue(this.lastUsedTelephone);
        r100.writeValue(this.lastUsedTelephoneTimeStamp);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public ContactEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(EntityExtKt.e(r110), r110.readLong(), r110.readLong(), EntityExtKt.e(r110), r110.createTypedArrayList(MetaTelephone.CREATOR));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        int r100 = r110.readInt();
        this.avatar = (FileEntity) r110.readParcelable(FileEntity.class.getClassLoader());
        this.note = r110.readString();
        GenderEnum.a r101 = GenderEnum.Companion;
        String r102 = r110.readString();
        r101.getClass();
        if (r102 != null) goto L11;
    L8:
        GenderEnum r103 = null;
    L9:
        this.gender = r103;
        this.credentialNumbers = r110.createTypedArrayList(MetaCredentialNumber.CREATOR);
        this.emails = r110.createTypedArrayList(MetaEmailAddress.CREATOR);
        this.addresses = r110.createTypedArrayList(MetaAddress.CREATOR);
        this.company = r110.readString();
        this.instantMessagings = r110.createTypedArrayList(MetaInstantMessaging.CREATOR);
        this.anniversaries = r110.createTypedArrayList(MetaAnniversary.CREATOR);
        this.voip = r110.readString();
        this.relationShips = r110.createTypedArrayList(MetaRelationship.CREATOR);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 6, r100);
        return;
    L11:
        r103 = GenderEnum.valueOf(r102);     // Catch: IllegalArgumentException -> L7
    L7:
        Reflection.getOrCreateKotlinClass(GenderEnum.class).getSimpleName();
        goto L8
    }
}
