package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushContainerSectionsChangedNotification extends Message<PushContainerSectionsChangedNotification, Builder> {
    public static final ProtoAdapter<PushContainerSectionsChangedNotification> ADAPTER = null;
    public static final ProtoAdapter_PushContainerSectionsChangedNotification RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TaskContainerSection> task_container_sections;

    public static final class Builder extends Message.Builder<PushContainerSectionsChangedNotification, Builder> implements d<PushContainerSectionsChangedNotification> {
        public List<TaskContainerSection> task_container_sections;

        @Override // com.squareup.wire.Message.Builder
        public PushContainerSectionsChangedNotification build() {
            return new PushContainerSectionsChangedNotification(this.task_container_sections, super.buildUnknownFields());
        }

        public Builder() {
            this.task_container_sections = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder task_container_sections(List<TaskContainerSection> r100) {
            Internal.checkElementsNotNull(r100);
            this.task_container_sections = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushContainerSectionsChangedNotification extends ProtoAdapter<PushContainerSectionsChangedNotification> implements c<PushContainerSectionsChangedNotification> {
        public ProtoAdapter_PushContainerSectionsChangedNotification() {
            super(FieldEncoding.LENGTH_DELIMITED, PushContainerSectionsChangedNotification.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushContainerSectionsChangedNotification decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.task_container_sections.add(TaskContainerSection.ADAPTER.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushContainerSectionsChangedNotification r100) {
            return TaskContainerSection.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.task_container_sections) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushContainerSectionsChangedNotification decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushContainerSectionsChangedNotification r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushContainerSectionsChangedNotification r101) throws IOException {
            TaskContainerSection.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.task_container_sections);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushContainerSectionsChangedNotification r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushContainerSectionsChangedNotification r100 = new ProtoAdapter_PushContainerSectionsChangedNotification();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.task_container_sections = Internal.copyOf("task_container_sections", this.task_container_sections);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushContainerSectionsChangedNotification.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushContainerSectionsChangedNotification(List<TaskContainerSection> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PushContainerSectionsChangedNotification(List<TaskContainerSection> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.task_container_sections = Internal.immutableCopyOf("task_container_sections", r100);
    }
}
