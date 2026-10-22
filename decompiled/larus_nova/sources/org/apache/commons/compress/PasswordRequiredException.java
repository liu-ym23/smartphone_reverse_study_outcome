package org.apache.commons.compress;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class PasswordRequiredException extends IOException {
    private static final long serialVersionUID = 1391070005491684483L;

    public PasswordRequiredException(String r100) {
        super("Cannot read encrypted content from " + r100 + " without a password.");
    }
}
