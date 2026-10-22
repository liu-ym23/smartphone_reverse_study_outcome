package com.google.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class UninitializedMessageException extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;
    private final List<String> missingFields;

    public InvalidProtocolBufferException asInvalidProtocolBufferException() {
        return new InvalidProtocolBufferException(getMessage());
    }

    public List<String> getMissingFields() {
        return Collections.unmodifiableList(this.missingFields);
    }

    public UninitializedMessageException(List<String> r100) {
        super(buildDescription(r100));
        this.missingFields = r100;
    }

    private static String buildDescription(List<String> r100) {
        StringBuilder r101 = new StringBuilder("Message missing required fields: ");
        Iterator<String> r102 = r100.iterator();
        boolean r103 = true;
    L4:
        if (r102.hasNext() == false) goto L11;
        String r104 = r102.next();
        if (r103 == false) goto L8;
        r103 = false;
    L9:
        r101.append(r104);
        goto L4
    L8:
        r101.append(", ");
        goto L9
    L11:
        return r101.toString();
    }

    public UninitializedMessageException(MessageLite r100) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.missingFields = null;
    }
}
