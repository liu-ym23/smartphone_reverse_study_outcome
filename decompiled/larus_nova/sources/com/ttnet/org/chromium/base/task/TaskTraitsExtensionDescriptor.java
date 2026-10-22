package com.ttnet.org.chromium.base.task;

/* JADX INFO: loaded from: classes41.dex */
public interface TaskTraitsExtensionDescriptor<Extension> {
    Extension fromSerializedData(byte[] r100);

    int getId();

    byte[] toSerializedData(Extension r100);
}
